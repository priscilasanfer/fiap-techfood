package br.com.fiap.techfood.application.core.domains

import java.util.UUID

//TODO
class OrderDomain {

    var id: UUID? = null;
    var name: String? = null;
    var items: List<OrderItem>? = null;
    var status: Int? = null;
    var isAnonymous: Boolean? = true;
    var client: ClientDomain? = null;


}