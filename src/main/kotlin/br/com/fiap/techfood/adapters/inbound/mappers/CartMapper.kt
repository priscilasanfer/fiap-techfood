package br.com.fiap.techfood.adapters.inbound.mappers

import br.com.fiap.techfood.adapters.dtos.CartDTO
import br.com.fiap.techfood.adapters.dtos.OrderItemDto
import br.com.fiap.techfood.application.core.domains.CartDomain
import br.com.fiap.techfood.application.core.domains.OrderItemDomain
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Component
import java.util.stream.Collectors

@Component
class CartMapper {
    fun toCartDomain(cartDTO: CartDTO): CartDomain {
        val cartDomain = CartDomain()
        cartDomain.cartProducts = toOrderItemDomainList(cartDTO.cartProducts)
        return cartDomain
    }

    fun toOrderItemDomainList(items: List<OrderItemDto?>?): List<OrderItemDomain>? {
        if (items == null) {
            return null
        }
        return items.stream().map { orderItemDto: OrderItemDto? -> this.toOrderItemDomain(orderItemDto) }
            .collect(Collectors.toList())
    }

    fun toOrderItemDomain(orderItemDto: OrderItemDto?): OrderItemDomain {
        val orderItemDomain = OrderItemDomain()
        BeanUtils.copyProperties(orderItemDto!!, orderItemDomain)
        return orderItemDomain
    }
}
