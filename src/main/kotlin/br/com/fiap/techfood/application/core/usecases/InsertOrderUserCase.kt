package br.com.fiap.techfood.application.core.usecases

import br.com.fiap.techfood.application.core.domains.ClientDomain
import br.com.fiap.techfood.application.core.domains.OrderDomain
import br.com.fiap.techfood.application.ports.inbound.InsertOrderInputPort
import br.com.fiap.techfood.application.ports.outbound.InsertOrderOutputPort

class InsertOrderUserCase(private var insertOrderOutputPort: InsertOrderOutputPort) : InsertOrderInputPort {
    override fun insert(order: OrderDomain?, client: ClientDomain?): OrderDomain? {
        return insertOrderOutputPort.insert(order, client)
    }
}
