package br.com.fiap.techfood.adapters.dtos

import java.util.*

class OrderItemDto (
    var productId: UUID? = null,
    var quantity: Int? = null,
    var description: String? = null,
)
