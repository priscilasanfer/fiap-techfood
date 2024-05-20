package br.com.fiap.techfood.core.application.domains

import java.util.*

class CartDomain {
    var id: UUID? = null
    var cartProducts: List<OrderItemDomain>? = null
    var orderName: String? = null
}
