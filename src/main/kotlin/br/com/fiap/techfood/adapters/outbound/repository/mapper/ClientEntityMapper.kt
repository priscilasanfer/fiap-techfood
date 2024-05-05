package br.com.fiap.techfood.adapters.outbound.repository.mapper

import br.com.fiap.techfood.adapters.outbound.repository.entity.ClientEntity
import br.com.fiap.techfood.application.core.domain.ClientDomain
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