package br.com.fiap.techfood.application.ports.outbound

import br.com.fiap.techfood.application.core.domains.ClientDomain
import br.com.fiap.techfood.application.core.domains.OrderDomain

interface InsertOrderOutputPort {
    fun insert(order: OrderDomain?, client: ClientDomain?): OrderDomain?
}
