package br.com.fiap.techfood.application.ports.outbound.order

import br.com.fiap.techfood.application.core.domains.ClientDomain
import br.com.fiap.techfood.application.core.domains.Order

interface InsertOrderOutputPort {
    fun insert(order: Order?, client: ClientDomain?): Order?
}
