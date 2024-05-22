package br.com.fiap.techfood.core.ports.inbound

import br.com.fiap.techfood.core.application.domains.OrderRequestDomain
import br.com.fiap.techfood.core.application.domains.OrderDomain
import br.com.fiap.techfood.core.application.domains.enums.OrderStatusEnum
import java.util.*

interface OrderInboundPort {

    fun save(orderRequest: OrderRequestDomain, clientCpf: String?): OrderDomain

    fun findById(id: UUID): OrderDomain

    fun findAllByStatus(orderStatus: OrderStatusEnum): List<OrderDomain>

    fun delete(id: UUID)

    fun approvePayment(id: UUID): String;

    fun prepareOrder(id: UUID);

    fun finishOrder(id: UUID);

}
