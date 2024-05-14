package br.com.fiap.techfood.adapters.inbound.mappers

import br.com.fiap.techfood.adapters.dtos.OrderDto
import br.com.fiap.techfood.application.core.domains.Order
import org.springframework.stereotype.Component

@Component
class OrderMapper {
    //TODO
    fun toOrder(orderDto: OrderDto?): Order {
        val order = Order()

        return order
    }
}
