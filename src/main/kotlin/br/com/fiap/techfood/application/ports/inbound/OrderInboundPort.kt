package br.com.fiap.techfood.application.ports.inbound

import br.com.fiap.techfood.application.core.domains.CartDomain
import br.com.fiap.techfood.application.core.domains.ClientDomain
import br.com.fiap.techfood.application.core.domains.OrderDomain
import br.com.fiap.techfood.application.core.domains.enums.OrderStatusEnum
import java.util.*

interface OrderInboundPort {

    fun save(cartDomain: CartDomain, clientDomain: ClientDomain?): OrderDomain

    fun findById(id: UUID): Optional<OrderDomain>

    fun findAllByStatus(orderStatus: OrderStatusEnum): List<OrderDomain>

    fun delete(id: UUID)

    fun approvePayment(id: UUID): String;

    fun prepareOrder(id: UUID);

    fun finishOrder(id: UUID);

}
