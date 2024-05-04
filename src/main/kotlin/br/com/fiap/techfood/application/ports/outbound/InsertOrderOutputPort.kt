package br.com.fiap.techfood.application.ports.outbound

import br.com.fiap.techfood.application.core.domain.ClientDomain
import br.com.fiap.techfood.application.core.domain.Order

interface InsertOrderOutputPort {
    fun insert(order: Order?, client: ClientDomain?): Order?
}
