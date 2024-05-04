package br.com.fiap.techfood.application.core.usercase

import br.com.fiap.techfood.application.core.domain.ClientDomain
import br.com.fiap.techfood.application.core.domain.Order
import br.com.fiap.techfood.application.ports.inbound.InsertOrderInputPort
import br.com.fiap.techfood.application.ports.outbound.InsertOrderOutputPort

class InsertOrderUserCase(private var insertOrderOutputPort: InsertOrderOutputPort) : InsertOrderInputPort {
    override fun insert(order: Order?, client: ClientDomain?): Order? {
        return insertOrderOutputPort.insert(order, client)
    }
}
