package br.com.fiap.techfood.application.core.usercase

import br.com.fiap.techfood.application.core.domain.ClientDomain
import br.com.fiap.techfood.application.ports.inbound.ClientInboundPort
import br.com.fiap.techfood.application.ports.outbound.ClientOutboundPort

class ClientUseCase(private var customerPersistencePort: ClientInboundPort) : ClientOutboundPort {
    override fun save(client: ClientDomain): ClientDomain {
        return customerPersistencePort.save(client)
    }
}
