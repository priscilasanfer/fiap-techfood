package br.com.fiap.techfood.adapters.inbound.mappers

import br.com.fiap.techfood.adapters.dtos.OrderDto
import br.com.fiap.techfood.adapters.dtos.OrderItemDto
import br.com.fiap.techfood.application.core.domains.OrderDomain
import br.com.fiap.techfood.application.core.domains.OrderItemDomain
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Component

@Component
class OrderMapper {


    fun toOrderDto(orderDomain: OrderDomain): OrderDto {
        val orderDto = OrderDto()
        BeanUtils.copyProperties(orderDomain, orderDto);

        orderDto.items = orderDomain.items?.map { toOrderItemDto(it) }
        //mesmo para client

        return orderDto;
    }

    fun toOrderItemDto(orderItemDomain: OrderItemDomain): OrderItemDto {
        val orderItemDto = OrderItemDto();
        BeanUtils.copyProperties(orderItemDomain, orderItemDto);
        return orderItemDto;
    }

}
