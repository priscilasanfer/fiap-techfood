package br.com.fiap.techfood.adapters.outbound

import br.com.fiap.techfood.adapters.outbound.repository.ClientRepository
import br.com.fiap.techfood.adapters.outbound.repository.mappers.ClientEntityMapper
import br.com.fiap.techfood.application.core.domains.ClientDomain
import br.com.fiap.techfood.application.core.domains.PageInfo
import br.com.fiap.techfood.application.ports.inbound.ClientInboundPort
import br.com.fiap.techfood.application.ports.outbound.ClientOutboundPort
import jakarta.transaction.Transactional
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component
import java.util.*

@Component
class ClientAdapter(
    private var clientEntityMapper: ClientEntityMapper,
    private var clientRepository: ClientRepository
) :
    ClientOutboundPort {

    @Transactional
    override fun save(clientDomain: ClientDomain): ClientDomain {
        val clientEntity = clientEntityMapper.toClientEntity(clientDomain)
        val clientEntitySaved = clientRepository.save(clientEntity)
        return clientEntityMapper.toClientDomain(clientEntitySaved)
    }

    override fun findById(id: UUID): Optional<ClientDomain> {
        return clientRepository.findById(id).map {
            clientEntity -> clientEntityMapper.toClientDomain(clientEntity)
        }
    }

    override fun findByCpf(cpf: String): Optional<ClientDomain> {
        return clientRepository.findByCpf(cpf).map {
                clientEntity -> clientEntityMapper.toClientDomain(clientEntity)
        }
    }

    override fun findAll(pageable: Pageable): List<ClientDomain> {
        return clientRepository.findAll(pageable)
            .content
            .filterNotNull()
            .map { entity -> clientEntityMapper.toClientDomain(entity) }
    }

    @Transactional
    override fun delete(clientDomain: ClientDomain) {
        val clientEntity = clientEntityMapper.toClientEntity(clientDomain)
        clientRepository.delete(clientEntity)
    }
}
