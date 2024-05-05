package br.com.fiap.techfood.application.core.usercase

import br.com.fiap.techfood.application.core.domain.ClientDomain
import br.com.fiap.techfood.application.ports.inbound.ClientInboundPort
import br.com.fiap.techfood.application.ports.outbound.ClientOutboundPort

class ClientUseCase(private var clientOutboundPort: ClientOutboundPort) : ClientInboundPort {
    override fun save(clientDomain: ClientDomain): ClientDomain {
        return clientOutboundPort.save(clientDomain)
    }
}
