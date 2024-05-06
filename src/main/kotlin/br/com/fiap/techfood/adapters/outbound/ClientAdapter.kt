package br.com.fiap.techfood.adapters.outbound

import br.com.fiap.techfood.adapters.outbound.repository.ClientRepository
import br.com.fiap.techfood.adapters.outbound.repository.entities.ClientEntity
import br.com.fiap.techfood.adapters.outbound.repository.mappers.ClientEntityMapper
import br.com.fiap.techfood.application.core.domains.ClientDomain
import br.com.fiap.techfood.application.core.domains.PageInfo
import br.com.fiap.techfood.application.ports.outbound.ClientOutboundPort
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component
import java.util.*

@Component
class ClientAdapter(
    private var clientRepository: ClientRepository,
    private var clientEntityMapper: ClientEntityMapper,
) :
    ClientOutboundPort {
    override fun save(clientDomain: ClientDomain): ClientDomain {
        val clientEntity = clientEntityMapper.toClientEntity(clientDomain)
        val clientEntitySaved = clientRepository.save(clientEntity)
        return clientEntityMapper.toClientDomain(clientEntitySaved)
    }

    override fun findById(id: UUID): Optional<ClientDomain> {
        val clientEntityOptional: Optional<ClientEntity> = clientRepository.findById(id)

        return if (clientEntityOptional.isPresent) {
            val clientDomain = clientEntityMapper.toClientDomain(clientEntityOptional.get())
            Optional.of(clientDomain)
        } else {
            Optional.empty<ClientDomain>()
        }
    }

    override fun findAll(pageInfo: PageInfo): List<ClientDomain> {
        val pageable: Pageable = PageRequest.of(pageInfo.pageNumber, pageInfo.pageSize)
        return clientRepository.findAll(pageable)
            .content
            .filterNotNull()
            .map { entity -> clientEntityMapper.toClientDomain(entity) }
    }

    override fun delete(clientDomain: ClientDomain) {
        val clientEntity = clientEntityMapper.toClientEntity(clientDomain)
        clientRepository.delete(clientEntity)
    }
}
