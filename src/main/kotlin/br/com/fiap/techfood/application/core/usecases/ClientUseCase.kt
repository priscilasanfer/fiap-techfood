package br.com.fiap.techfood.application.core.usecases

import br.com.fiap.techfood.application.core.domains.Client
import br.com.fiap.techfood.application.core.domains.PageInfo
import br.com.fiap.techfood.application.ports.inbound.ClientInboundPort
import br.com.fiap.techfood.application.ports.outbound.ClientOutboundPort
import java.util.*

class ClientUseCase(private var clientOutboundPort: ClientOutboundPort) : ClientInboundPort {
    override fun save(clientDomain: Client): Client {
        return clientOutboundPort.save(clientDomain)
    }

    override fun findById(id: UUID): Optional<Client> {
        return  clientOutboundPort.findById(id)
    }

    override fun findAll(pageInfo: PageInfo): List<Client> {
        return clientOutboundPort.findAll(pageInfo)
    }

    override fun delete(clientDomain: Client) {
        return clientOutboundPort.delete(clientDomain)
    }
}
