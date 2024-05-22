package br.com.fiap.techfood.core.application.domains

class OrderRequestDomain {
    var requestProducts: List<OrderItemDomain>? = null
    var orderName: String? = null
}
