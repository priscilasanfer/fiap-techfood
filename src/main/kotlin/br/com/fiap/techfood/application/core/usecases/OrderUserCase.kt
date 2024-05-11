package br.com.fiap.techfood.application.core.usecases

import br.com.fiap.techfood.application.core.domains.CartDomain
import br.com.fiap.techfood.application.core.domains.ClientDomain
import br.com.fiap.techfood.application.core.domains.OrderDomain
import br.com.fiap.techfood.application.core.domains.OrderItemDomain
import br.com.fiap.techfood.application.core.domains.enums.OrderStatusEnum
import br.com.fiap.techfood.application.ports.inbound.OrderInboundPort
import br.com.fiap.techfood.application.ports.outbound.CpfValidationOutputPort
import br.com.fiap.techfood.application.ports.outbound.OrderOutboundPort
import br.com.fiap.techfood.application.ports.outbound.ProductOutboundPort
import java.util.*
import java.util.stream.Collectors

class OrderUserCase : OrderInboundPort {
    private val cpfValidationOutputPort: CpfValidationOutputPort? = null
    private val orderOutboundPort: OrderOutboundPort? = null
    private val productOutboundPort: ProductOutboundPort? = null

    override fun save(cartDomain: CartDomain, clientDomain: ClientDomain?): OrderDomain {
        var orderDomain = OrderDomain()
        orderDomain.status = OrderStatusEnum.AWAITING_PAYMENT

        if (cartDomain.cartProducts == null || cartDomain.cartProducts.isEmpty()) {
            throw RuntimeException("Nenhum produto foi selecionado.")
        }

        //esse problema não aconteceria com um frontend, mas tem que validar novamente
        if (clientDomain != null && clientDomain.cpf.isNotBlank()) {
            val isValidCpf = cpfValidationOutputPort!!.isValid(clientDomain.cpf)
            if (!isValidCpf) {
                throw RuntimeException("CPF não valido")
            }

            //checar se cliente existe?
            orderDomain.client = clientDomain
        }

        //checkIfAllProductsExists
        val productIdList = cartDomain.cartProducts.stream().map(OrderItemDomain::productId).collect(Collectors.toSet())
        val productList = productOutboundPort!!.findAllByIds(productIdList)
        if (productList.size != productIdList.size) {
            //não foram encontrados todos os produtos
            //TODO POSSIVEL fazer logica para pegar id
            //Id e nome do produto no OrderItemModel??
            throw RuntimeException("Não foram encontrados todos os produtos solicitados.")
        }

        orderDomain.items = cartDomain.cartProducts
        orderDomain = orderOutboundPort!!.save(orderDomain)
        return orderDomain
    }

    override fun findById(id: UUID): Optional<OrderDomain> {
        return orderOutboundPort!!.findById(id)
    }

    //PARA TELA DA COZINHA
    override fun findAllApprovedOrders(): List<OrderDomain> {
        return orderOutboundPort!!.findAllByOrderStatus(OrderStatusEnum.PAYMENT_APPROVED)
    }

    //PARA TELA DE CLIENTES
    override fun findAllPrepared(): List<OrderDomain> {
        return orderOutboundPort!!.findAllByOrderStatus(OrderStatusEnum.PREPARED)
    }

    //CHECK IF EXISTS
    //STATUS != APPROVED OR FINISH
    //STATUS == AWAITING PAYMENT
    //expired
    override fun delete(id: UUID) {
        val optOrderDomain = orderOutboundPort!!.findById(id);
        if (optOrderDomain.isEmpty) {
            throw RuntimeException("Pedido não encontrado")
        }

        val orderDomain = optOrderDomain.get();
        if (orderDomain.status != OrderStatusEnum.AWAITING_PAYMENT) {
            throw RuntimeException("Só é possível deletar um pedido com status de aguardando pagamento.")
        }

        orderOutboundPort.delete(orderDomain.id!!);
    }

    //TODO CHECKOUT MOCK PODE PRECISAR DE MAIS INFO
    override fun approvePayment(id: UUID) {
        val optOrderDomain = orderOutboundPort!!.findById(id);
        if (optOrderDomain.isEmpty) {
            throw RuntimeException("Pedido não encontrado")
        }

        //TODO check status
        val orderDomain = optOrderDomain.get();
        if (orderDomain.status != OrderStatusEnum.AWAITING_PAYMENT) {
            throw RuntimeException("Só é possível aprovar pagamento de um pedido com status Aguardando Pagamento.")
        }

        //aprove
        orderOutboundPort.updateStatus(id, OrderStatusEnum.PAYMENT_APPROVED);
    }

    override fun prepareOrder(id: UUID) {
        val optOrderDomain = orderOutboundPort!!.findById(id);
        if (optOrderDomain.isEmpty) {
            throw RuntimeException("Pedido não encontrado")
        }

        //TODO check status
        val orderDomain = optOrderDomain.get();
        if (orderDomain.status != OrderStatusEnum.PAYMENT_APPROVED) {
            throw RuntimeException("Só é possível preparar pedidos com status Pagamento Aprovado.")
        }

        //aprove
        orderOutboundPort.updateStatus(id, OrderStatusEnum.PREPARED);
    }

    override fun finishOrder(id: UUID) {
        val optOrderDomain = orderOutboundPort!!.findById(id);
        if (optOrderDomain.isEmpty) {
            throw RuntimeException("Pedido não encontrado")
        }

        val orderDomain = optOrderDomain.get();
        if (orderDomain.status != OrderStatusEnum.PREPARED) {
            throw RuntimeException("Só é possível finalizar pedidos com status Preparado.")
        }

        orderOutboundPort.updateStatus(id, OrderStatusEnum.FINISHED);
    }

}
