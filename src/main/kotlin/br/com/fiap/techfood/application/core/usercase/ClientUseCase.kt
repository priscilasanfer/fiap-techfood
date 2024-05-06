package br.com.fiap.techfood.application.core.usercase

import br.com.fiap.techfood.application.core.domain.ClientDomain
import br.com.fiap.techfood.application.core.domain.PageInfo
import br.com.fiap.techfood.application.ports.inbound.ClientInboundPort
import br.com.fiap.techfood.application.ports.outbound.ClientOutboundPort
import java.util.*

class ClientUseCase(private var clientOutboundPort: ClientOutboundPort) : ClientInboundPort {
    override fun save(clientDomain: ClientDomain): ClientDomain {
        return clientOutboundPort.save(clientDomain)
    }

    override fun findById(id: UUID): Optional<ClientDomain> {
        return  clientOutboundPort.findById(id)
    }

    override fun findAll(pageInfo: PageInfo): List<ClientDomain> {
        return clientOutboundPort.findAll(pageInfo)
    }

    override fun delete(clientDomain: ClientDomain) {
        return clientOutboundPort.delete(clientDomain)
    }
}
