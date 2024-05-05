package br.com.fiap.techfood.adapters.inbound.mapper

import br.com.fiap.techfood.adapters.dto.OrderDTO
import br.com.fiap.techfood.application.core.domain.Order
import org.springframework.stereotype.Component

@Component
class OrderMapper {
    //TODO
    fun toOrder(orderDto: OrderDTO?): Order {
        val order = Order()

        return order
    }
}
