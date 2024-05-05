package br.com.fiap.techfood.application.core.usercase.order

import br.com.fiap.techfood.application.core.domain.Client
import br.com.fiap.techfood.application.core.domain.Order
import br.com.fiap.techfood.application.ports.inbound.order.InsertOrderInputPort
import br.com.fiap.techfood.application.ports.outbound.order.InsertOrderOutputPort

class InsertOrderUserCase(private var insertOrderOutputPort: InsertOrderOutputPort) : InsertOrderInputPort {
    override fun insert(order: Order?, client: Client?): Order? {
        return insertOrderOutputPort.insert(order, client)
    }
}
