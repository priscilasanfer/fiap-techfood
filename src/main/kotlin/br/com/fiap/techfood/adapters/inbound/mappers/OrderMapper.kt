package br.com.fiap.techfood.adapters.inbound.mappers

import br.com.fiap.techfood.adapters.dtos.OrderDto
import br.com.fiap.techfood.application.core.domains.OrderDomain
import org.springframework.stereotype.Component

@Component
class OrderMapper {
    //TODO
    fun toOrder(orderDto: OrderDto?): OrderDomain {
        val order = OrderDomain()

        return order
    }
}
