package br.com.fiap.techfood.application.ports.inbound

import br.com.fiap.techfood.application.core.domains.ClientDomain
import br.com.fiap.techfood.application.core.domains.OrderDomain

interface InsertOrderInputPort {
    fun insert(order: OrderDomain?, client: ClientDomain?): OrderDomain?
}
