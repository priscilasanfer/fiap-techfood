package br.com.fiap.techfood.adapters.dtos

import java.util.*

class CartDTO {
    var id: UUID? = null
    var cartProducts: List<OrderItemDto>? = null
}
