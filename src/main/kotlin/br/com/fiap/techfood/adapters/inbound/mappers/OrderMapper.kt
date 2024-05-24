package br.com.fiap.techfood.adapters.inbound.mappers

import br.com.fiap.techfood.adapters.dtos.OrderCreateDTO
import br.com.fiap.techfood.adapters.dtos.OrderDto
import br.com.fiap.techfood.adapters.dtos.OrderItemDto
import br.com.fiap.techfood.core.application.domains.OrderDomain
import br.com.fiap.techfood.core.application.domains.OrderItemDomain
import br.com.fiap.techfood.core.application.domains.OrderRequestDomain
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Component
import java.util.stream.Collectors

@Component
class OrderMapper(
    private val clientMapper: ClientMapper
) {

    fun toOrderDto(orderDomain: OrderDomain): OrderDto {
        val orderDto = OrderDto()
        BeanUtils.copyProperties(orderDomain, orderDto)
        orderDto.items = orderDomain.items?.map { toOrderItemDto(it) }

        if(orderDomain.client != null) {
            orderDto.client = clientMapper.toClientDTO(orderDomain.client!!)
        }

        return orderDto
    }

    fun toOrderItemDto(orderItemDomain: OrderItemDomain): OrderItemDto {
        val orderItemDto = OrderItemDto()
        BeanUtils.copyProperties(orderItemDomain, orderItemDto)
        return orderItemDto
    }

    fun toOrderRequestDomain(orderCreateDto: OrderCreateDTO): OrderRequestDomain {
        val orderRequestDomain = OrderRequestDomain()
        orderRequestDomain.orderName = orderCreateDto.orderName;
        orderRequestDomain.requestProducts = toOrderItemDomainList(orderCreateDto.orderItems)
        return orderRequestDomain
    }

    fun toOrderItemDomainList(items: List<OrderItemDto>?): List<OrderItemDomain>? {
        if (items == null) {
            return null
        }
        return items.stream().map { orderItemDto: OrderItemDto -> this.toOrderItemDomain(orderItemDto) }
            .collect(Collectors.toList())
    }

    fun toOrderItemDomain(orderItemDto: OrderItemDto): OrderItemDomain {
        val orderItemDomain = OrderItemDomain()
        BeanUtils.copyProperties(orderItemDto, orderItemDomain)
        return orderItemDomain
    }

}
