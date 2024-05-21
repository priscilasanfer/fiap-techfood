package br.com.fiap.techfood.core.application.domains

import java.util.UUID

data class OrderItemDomain (
    var quantity: Int? = null,
    var productId: UUID? = null,
    var description: String? = null
)
