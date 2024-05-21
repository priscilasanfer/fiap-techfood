package br.com.fiap.techfood.core.ports.inbound

import br.com.fiap.techfood.core.application.domains.ClientDomain
import br.com.fiap.techfood.core.application.domains.OrderDomain

interface InsertOrderInputPort {
    fun insert(order: OrderDomain?, client: ClientDomain?): OrderDomain?
}
