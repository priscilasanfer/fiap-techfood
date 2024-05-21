package br.com.fiap.techfood.adapters.outbound

import br.com.fiap.techfood.adapters.outbound.repository.ClientRepository
import br.com.fiap.techfood.adapters.outbound.repository.mappers.ClientEntityMapper
import br.com.fiap.techfood.core.application.domains.ClientDomain
import br.com.fiap.techfood.core.application.domains.exceptions.DataIntegrityException
import br.com.fiap.techfood.core.ports.outbound.repositories.ClientRepositoryCore
import jakarta.transaction.Transactional
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component
import java.util.*

@Component
class ClientRepositoryAdapter(
    private val clientEntityMapper: ClientEntityMapper,
    private val clientRepository: ClientRepository
) :
    ClientRepositoryCore {

    @Transactional
    override fun save(clientDomain: ClientDomain): ClientDomain {
        val clientEntity = clientEntityMapper.toClientEntity(clientDomain)
        val clientEntitySaved = clientRepository.save(clientEntity)
        return clientEntityMapper.toClientDomain(clientEntitySaved)
    }

    override fun findById(id: UUID): Optional<ClientDomain> {
        return clientRepository.findById(id).map { clientEntity ->
            clientEntityMapper.toClientDomain(clientEntity)
        }
    }

    override fun findByCpf(cpf: String): Optional<ClientDomain> {
        return clientRepository.findByCpf(cpf).map { clientEntity ->
            clientEntityMapper.toClientDomain(clientEntity)
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
