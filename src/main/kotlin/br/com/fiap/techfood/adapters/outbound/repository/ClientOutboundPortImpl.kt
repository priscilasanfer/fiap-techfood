package br.com.fiap.techfood.adapters.outbound.repository

import br.com.fiap.techfood.adapters.outbound.repository.entity.ClientEntity
import br.com.fiap.techfood.application.core.domain.ClientDomain
import br.com.fiap.techfood.application.ports.outbound.ClientOutboundPort
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Component

@Component
class ClientOutboundPortImpl(private var clientRepository: ClientRepository, private var modelMapper: ModelMapper) :
    ClientOutboundPort {
    override fun save(clientDomain: ClientDomain): ClientDomain {
        val clientEntity = clientRepository.save(modelMapper.map(clientDomain, ClientEntity::class.java))
        return modelMapper.map(clientEntity, ClientDomain::class.java)
    }
}
