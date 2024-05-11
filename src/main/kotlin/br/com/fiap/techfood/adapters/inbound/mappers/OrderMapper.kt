package br.com.fiap.techfood.adapters.inbound.mappers

import br.com.fiap.techfood.adapters.dtos.OrderDto
import br.com.fiap.techfood.application.core.domains.OrderDomain
import org.springframework.stereotype.Component

@Component
class OrderMapper {


    fun toOrderDto(orderDomain: OrderDomain): OrderDto {
        val orderDto = OrderDto()

        return orderDto;
    }


}
