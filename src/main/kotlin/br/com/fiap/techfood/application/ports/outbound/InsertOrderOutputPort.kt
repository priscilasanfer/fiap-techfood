package br.com.fiap.techfood.application.ports.outbound

import br.com.fiap.techfood.application.core.domains.Client
import br.com.fiap.techfood.application.core.domains.Order

interface InsertOrderOutputPort {
    fun insert(order: Order?, client: Client?): Order?
}
