package br.com.fiap.techfood.application.ports.inbound.order

import br.com.fiap.techfood.application.core.domains.ClientDomain
import br.com.fiap.techfood.application.core.domains.Order

interface InsertOrderInputPort {
    fun insert(order: Order?, client: ClientDomain?): Order?
}
