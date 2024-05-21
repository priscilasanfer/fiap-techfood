package br.com.fiap.techfood.adapters.outbound.repository.mappers

import br.com.fiap.techfood.adapters.outbound.repository.entities.ClientEntity
import br.com.fiap.techfood.core.application.domains.ClientDomain
import org.springframework.stereotype.Component

@Component
class ClientEntityMapper {
    fun toClientDomain(clientEntity: ClientEntity): ClientDomain {
        return ClientDomain(
            id = clientEntity.id,
            cpf = clientEntity.cpf,
            name = clientEntity.name,
            email = clientEntity.email,
        )
    }

    fun toClientEntity(clientDomain: ClientDomain): ClientEntity {
        return ClientEntity(
            id= clientDomain.id,
            cpf = clientDomain.cpf,
            name = clientDomain.name,
            email = clientDomain.email
        )
    }
}