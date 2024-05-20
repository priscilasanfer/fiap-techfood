package br.com.fiap.techfood.core.application.usecases

import br.com.fiap.techfood.core.application.domains.CartDomain
import br.com.fiap.techfood.core.application.domains.ClientDomain
import br.com.fiap.techfood.core.application.domains.OrderDomain
import br.com.fiap.techfood.core.application.domains.OrderItemDomain
import br.com.fiap.techfood.core.application.domains.enums.OrderStatusEnum
import br.com.fiap.techfood.core.application.domains.exceptions.DataIntegrityException
import br.com.fiap.techfood.core.application.domains.exceptions.ObjectNotFoundException
import br.com.fiap.techfood.core.ports.inbound.OrderInboundPort
import br.com.fiap.techfood.core.ports.outbound.CpfValidationOutputPort
import br.com.fiap.techfood.core.ports.outbound.repositories.OrderRepositoryCore
import br.com.fiap.techfood.core.ports.outbound.repositories.ProductRepositoryCore
import java.util.*
import java.util.stream.Collectors

class OrderUserCase(
    private val cpfValidationOutputPort: CpfValidationOutputPort,
    private val orderRepositoryCore: OrderRepositoryCore,
    private val productRepositoryCore: ProductRepositoryCore,
) : OrderInboundPort {

    override fun save(cartDomain: CartDomain, clientDomain: ClientDomain?): OrderDomain {
        var orderDomain = OrderDomain()
        orderDomain.status = OrderStatusEnum.AWAITING_PAYMENT

        if (cartDomain.orderName != null && cartDomain.orderName!!.length >= 3) {
            orderDomain.name = cartDomain.orderName;
        } else {
            throw DataIntegrityException("There must be at least 3 characters in the order name");
        }

        if (cartDomain.cartProducts == null || cartDomain.cartProducts!!.isEmpty()) {
            throw DataIntegrityException("No products were selected.")
        }

        if (clientDomain?.cpf != null && clientDomain.cpf!!.isNotBlank()) {
            val isValidCpf = cpfValidationOutputPort.isValid(clientDomain.cpf)
            if (!isValidCpf) {
                throw DataIntegrityException("CPF: ${clientDomain.cpf} is not valid")
            }

            orderDomain.client = clientDomain
        }

        cartDomain.cartProducts!!.forEach {
            if (it.quantity == null || it.quantity!! <= 0) {
                throw DataIntegrityException("Ordered Item Quantity cannot be less than or equal to 0");
            }
        }

        val productIdList: MutableSet<UUID> =
            cartDomain.cartProducts!!.stream().map(OrderItemDomain::productId).collect(Collectors.toSet())
        val productList = productRepositoryCore.findAllByIds(productIdList)
        if (productList.size != productIdList.size) {
            throw ObjectNotFoundException("Not all requested products were found.")
        }

        orderDomain.items = cartDomain.cartProducts
        orderDomain = orderRepositoryCore.save(orderDomain)
        return orderDomain
    }

    override fun findById(id: UUID): Optional<OrderDomain> {
        return orderRepositoryCore.findById(id)
    }

    override fun findAllApprovedOrders(): List<OrderDomain> {
        return orderRepositoryCore.findAllByOrderStatus(OrderStatusEnum.PAYMENT_APPROVED)
    }

    override fun findAllPrepared(): List<OrderDomain> {
        return orderRepositoryCore.findAllByOrderStatus(OrderStatusEnum.PREPARED)
    }

    override fun delete(id: UUID) {
        val optOrderDomain = orderRepositoryCore.findById(id);
        if (optOrderDomain.isEmpty) {
            throw ObjectNotFoundException("Order $id not found.")
        }

        val orderDomain = optOrderDomain.get();
        if (orderDomain.status != OrderStatusEnum.AWAITING_PAYMENT) {
            throw DataIntegrityException("It is only possible to delete an order with the status of awaiting payment.")
        }

        orderRepositoryCore.delete(orderDomain.id!!);
    }

    override fun approvePayment(id: UUID): String {
        val optOrderDomain = orderRepositoryCore.findById(id);
        if (optOrderDomain.isEmpty) {
            throw ObjectNotFoundException("Order $id not found.")
        }

        val orderDomain = optOrderDomain.get();
        if (orderDomain.status != OrderStatusEnum.AWAITING_PAYMENT) {
            throw DataIntegrityException("It is only possible to approve payment for an order with status Awaiting Payment.")
        }

        orderRepositoryCore.updateStatus(id, OrderStatusEnum.PAYMENT_APPROVED);
        return "Payment Aprroved";
    }

    override fun prepareOrder(id: UUID) {
        val optOrderDomain = orderRepositoryCore.findById(id);
        if (optOrderDomain.isEmpty) {
            throw ObjectNotFoundException("Order $id not found.")
        }

        val orderDomain = optOrderDomain.get();
        if (orderDomain.status != OrderStatusEnum.PAYMENT_APPROVED) {
            throw DataIntegrityException("It is only possible to prepare orders with Payment Approved status.")
        }

        orderRepositoryCore.updateStatus(id, OrderStatusEnum.PREPARED);
    }

    override fun finishOrder(id: UUID) {
        val optOrderDomain = orderRepositoryCore.findById(id);
        if (optOrderDomain.isEmpty) {
            throw ObjectNotFoundException("Order $id not found.")
        }

        val orderDomain = optOrderDomain.get();
        if (orderDomain.status != OrderStatusEnum.PREPARED) {
            throw DataIntegrityException("It is only possible to finalize orders with a Ready status.")
        }

        orderRepositoryCore.updateStatus(id, OrderStatusEnum.FINISHED);
    }

}
