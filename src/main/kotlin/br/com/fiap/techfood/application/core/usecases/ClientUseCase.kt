package br.com.fiap.techfood.application.core.usecases

import br.com.fiap.techfood.adapters.outbound.repository.ClientRepository
import br.com.fiap.techfood.adapters.outbound.repository.entities.ClientEntity
import br.com.fiap.techfood.adapters.outbound.repository.mappers.ClientEntityMapper
import br.com.fiap.techfood.application.core.domains.ClientDomain
import br.com.fiap.techfood.application.core.domains.PageInfo
import br.com.fiap.techfood.application.ports.inbound.ClientInboundPort
import br.com.fiap.techfood.application.ports.outbound.ClientOutboundPort
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class ClientUseCase(
    private var clientOutboundPort: ClientOutboundPort,
) : ClientInboundPort {

    override fun save(clientDomain: ClientDomain): ClientDomain {
        return clientOutboundPort.save(clientDomain)
    }

    override fun findById(id: UUID): Optional<ClientDomain> {
        val clientEntityOptional: Optional<ClientDomain> = clientOutboundPort.findById(id)

        return if (clientEntityOptional.isPresent) {
            clientEntityOptional
        } else {
            Optional.empty<ClientDomain>()
        }
    }

    override fun findByCpf(cpf: String): Optional<ClientDomain> {
        return clientOutboundPort.findByCpf(cpf)
    }

    override fun findAll(pageInfo: PageInfo): List<ClientDomain> {
        val pageable: Pageable = PageRequest.of(pageInfo.pageNumber, pageInfo.pageSize)
        return clientOutboundPort.findAll(pageable)
    }

    override fun delete(clientDomain: ClientDomain) {
        clientOutboundPort.delete(clientDomain)
    }
}
