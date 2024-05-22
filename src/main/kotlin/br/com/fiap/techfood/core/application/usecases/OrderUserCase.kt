package br.com.fiap.techfood.core.application.usecases

import br.com.fiap.techfood.core.application.domains.OrderDomain
import br.com.fiap.techfood.core.application.domains.OrderItemDomain
import br.com.fiap.techfood.core.application.domains.OrderRequestDomain
import br.com.fiap.techfood.core.application.domains.enums.OrderStatusEnum
import br.com.fiap.techfood.core.application.domains.exceptions.DataIntegrityException
import br.com.fiap.techfood.core.application.domains.exceptions.ObjectNotFoundException
import br.com.fiap.techfood.core.ports.inbound.OrderInboundPort
import br.com.fiap.techfood.core.ports.outbound.repositories.ClientRepositoryCore
import br.com.fiap.techfood.core.ports.outbound.repositories.OrderRepositoryCore
import br.com.fiap.techfood.core.ports.outbound.repositories.ProductRepositoryCore
import java.util.*
import java.util.stream.Collectors

class OrderUserCase(
    private val orderRepositoryCore: OrderRepositoryCore,
    private val productRepositoryCore: ProductRepositoryCore,
    private val clientRepositoryCore: ClientRepositoryCore,
) : OrderInboundPort {

    override fun save(orderRequest: OrderRequestDomain, clientCpf: String?): OrderDomain {
        var orderDomain = OrderDomain()
        orderDomain.status = OrderStatusEnum.AWAITING_PAYMENT

        if (orderRequest.orderName != null && orderRequest.orderName!!.length >= 3) {
            orderDomain.name = orderRequest.orderName;
        } else {
            throw DataIntegrityException("There must be at least 3 characters in the order name");
        }

        if (orderRequest.requestProducts == null || orderRequest.requestProducts!!.isEmpty()) {
            throw DataIntegrityException("No products were selected.")
        }

        if (!clientCpf.isNullOrBlank()) {
            val clientDomainOpt = clientRepositoryCore.findByCpf(clientCpf)
            if (clientDomainOpt.isEmpty) {
                throw DataIntegrityException("Client with CPF $clientCpf not found. Make sure you have a registration.")
            }
            orderDomain.client = clientDomainOpt.get();
        }

        orderRequest.requestProducts!!.forEach {
            if (it.quantity == null || it.quantity!! <= 0) {
                throw DataIntegrityException("Ordered Item Quantity cannot be less than or equal to 0");
            }
        }

        val productIdList: MutableSet<UUID> =
            orderRequest.requestProducts!!.stream().map(OrderItemDomain::productId).collect(Collectors.toSet())
        val productList = productRepositoryCore.findAllByIds(productIdList)
        if (productList.size != productIdList.size) {
            throw ObjectNotFoundException("Not all requested products were found.")
        }

        orderDomain.items = orderRequest.requestProducts
        orderDomain = orderRepositoryCore.save(orderDomain)
        return orderDomain
    }

    override fun findById(id: UUID): OrderDomain {
        val optOrderDomain = orderRepositoryCore.findById(id);
        if (optOrderDomain.isEmpty) {
            throw ObjectNotFoundException("Order $id not found.")
        }
        return optOrderDomain.get();
    }

    override fun findAllByStatus(orderStatus: OrderStatusEnum): List<OrderDomain> {
        return orderRepositoryCore.findAllByOrderStatus(orderStatus)
    }

    override fun delete(id: UUID) {
        val orderDomain = this.findById(id);

        if (orderDomain.status != OrderStatusEnum.AWAITING_PAYMENT) {
            throw DataIntegrityException("It is only possible to delete an order with the status of awaiting payment.")
        }

        orderRepositoryCore.delete(orderDomain.id!!);
    }

    override fun approvePayment(id: UUID): String {
        val orderDomain = this.findById(id);

        if (orderDomain.status != OrderStatusEnum.AWAITING_PAYMENT) {
            throw DataIntegrityException("It is only possible to approve payment for an order with status Awaiting Payment.")
        }

        orderRepositoryCore.updateStatus(id, OrderStatusEnum.PAYMENT_APPROVED);
        return "Payment Aprroved";
    }

    override fun prepareOrder(id: UUID) {
        val orderDomain = this.findById(id);

        if (orderDomain.status != OrderStatusEnum.PAYMENT_APPROVED) {
            throw DataIntegrityException("It is only possible to prepare orders with Payment Approved status.")
        }

        orderRepositoryCore.updateStatus(id, OrderStatusEnum.PREPARED);
    }

    override fun finishOrder(id: UUID) {
        val orderDomain = this.findById(id);

        if (orderDomain.status != OrderStatusEnum.PREPARED) {
            throw DataIntegrityException("It is only possible to finalize orders with a Ready status.")
        }

        orderRepositoryCore.updateStatus(id, OrderStatusEnum.FINISHED);
    }

}
