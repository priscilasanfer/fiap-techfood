package br.com.fiap.techfood.application.ports.inbound

import br.com.fiap.techfood.application.core.domains.Client
import br.com.fiap.techfood.application.core.domains.Order

interface InsertOrderInputPort {
    fun insert(order: Order?, client: Client?): Order?
}
