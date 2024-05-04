package br.com.fiap.techfood.application.ports.inbound

import br.com.fiap.techfood.application.core.domain.ClientDomain
import br.com.fiap.techfood.application.core.domain.Order

interface InsertOrderInputPort {
    fun insert(order: Order?, client: ClientDomain?): Order?
}
