package br.com.fiap.techfood.core.application.usecases

import br.com.fiap.techfood.core.application.domains.ClientDomain
import br.com.fiap.techfood.core.application.domains.PageInfo
import br.com.fiap.techfood.core.ports.inbound.ClientInboundPort
import br.com.fiap.techfood.core.ports.outbound.repositories.ClientRepositoryCore
import java.util.*

class ClientUseCase(
    private val clientRepositoryCore: ClientRepositoryCore,
) : ClientInboundPort {

    override fun save(clientDomain: ClientDomain): ClientDomain {
        return clientRepositoryCore.save(clientDomain)
    }

    override fun findById(id: UUID): Optional<ClientDomain> {
        val clientEntityOptional: Optional<ClientDomain> = clientRepositoryCore.findById(id)

        return if (clientEntityOptional.isPresent) {
            clientEntityOptional
        } else {
            Optional.empty<ClientDomain>()
        }
    }

    override fun findByCpf(cpf: String): Optional<ClientDomain> {
        return clientRepositoryCore.findByCpf(cpf)
    }

    override fun findAll(pageInfo: PageInfo): List<ClientDomain> {
        return clientRepositoryCore.findAll(pageInfo)
    }

    override fun delete(clientDomain: ClientDomain) {
        clientRepositoryCore.delete(clientDomain)
    }
}
