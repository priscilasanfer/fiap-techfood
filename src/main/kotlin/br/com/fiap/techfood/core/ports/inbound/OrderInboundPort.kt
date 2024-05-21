package br.com.fiap.techfood.core.ports.inbound

import br.com.fiap.techfood.core.application.domains.CartDomain
import br.com.fiap.techfood.core.application.domains.ClientDomain
import br.com.fiap.techfood.core.application.domains.OrderDomain
import br.com.fiap.techfood.core.application.domains.enums.OrderStatusEnum
import java.util.*

interface OrderInboundPort {

    fun save(cartDomain: CartDomain, clientDomain: ClientDomain?): OrderDomain

    fun findById(id: UUID): OrderDomain

    fun findAllByStatus(orderStatus: OrderStatusEnum): List<OrderDomain>

    fun delete(id: UUID)

    fun approvePayment(id: UUID): String;

    fun prepareOrder(id: UUID);

    fun finishOrder(id: UUID);

}
