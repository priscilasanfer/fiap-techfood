package br.com.fiap.techfood.adapters.outbound.repository

import br.com.fiap.techfood.adapters.outbound.repository.mapper.ClientEntityMapper
import br.com.fiap.techfood.application.core.domain.ClientDomain
import br.com.fiap.techfood.application.ports.outbound.ClientOutboundPort
import org.springframework.stereotype.Component

@Component
class ClientOutboundPortImpl(
    private var clientRepository: ClientRepository,
    private var clientEntityMapper: ClientEntityMapper
) :
    ClientOutboundPort {
    override fun save(clientDomain: ClientDomain): ClientDomain {
        val clientEntity = clientEntityMapper.toClientEntity(clientDomain)
        val clientEntitySaved = clientRepository.save(clientEntity)
        return clientEntityMapper.toClientDomain(clientEntitySaved)
    }
}
