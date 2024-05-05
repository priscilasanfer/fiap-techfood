package br.com.fiap.techfood.application.ports.inbound.order

import br.com.fiap.techfood.application.core.domain.Client
import br.com.fiap.techfood.application.core.domain.Order

interface InsertOrderInputPort {
    fun insert(order: Order?, client: Client?): Order?
}
