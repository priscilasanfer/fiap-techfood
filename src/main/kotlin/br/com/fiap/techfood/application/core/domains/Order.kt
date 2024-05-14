package br.com.fiap.techfood.application.core.domains

import java.util.UUID

//TODO
class Order {

    var id: UUID? = null;
    var name: String? = null;
    var items: List<OrderItem>? = null;
    private var status: Int? = null;


}