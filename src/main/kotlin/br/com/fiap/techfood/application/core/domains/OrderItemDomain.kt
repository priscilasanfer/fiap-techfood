package br.com.fiap.techfood.application.core.domains

import java.util.UUID

class OrderItemDomain (
    var quantity: Int? = null,
    var productId: UUID? = null,
    var description: String? = null
)
