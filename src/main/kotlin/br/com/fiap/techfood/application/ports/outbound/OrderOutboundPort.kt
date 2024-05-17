package br.com.fiap.techfood.application.ports.outbound

import br.com.fiap.techfood.application.core.domains.OrderDomain
import br.com.fiap.techfood.application.core.domains.enums.OrderStatusEnum
import java.util.*

interface OrderOutboundPort {

    fun save(orderDomain: OrderDomain): OrderDomain

    fun findById(id: UUID): Optional<OrderDomain>

    fun findAllByOrderStatus(status: OrderStatusEnum): List<OrderDomain>

    fun delete(id: UUID)

    //CHECAR QUAIS PARAMS ID?
    fun updateStatus(id: UUID, status: OrderStatusEnum)
}
