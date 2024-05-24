package br.com.fiap.techfood.core.ports.outbound.repositories

import br.com.fiap.techfood.core.application.domains.OrderDomain
import br.com.fiap.techfood.core.application.domains.enums.OrderStatusEnum
import java.util.*

interface OrderRepositoryCore {

    fun save(orderDomain: OrderDomain): OrderDomain

    fun findById(id: UUID): Optional<OrderDomain>

    fun findAllByOrderStatus(status: OrderStatusEnum): List<OrderDomain>

    fun delete(id: UUID)

    fun updateStatus(id: UUID, status: OrderStatusEnum)

}
