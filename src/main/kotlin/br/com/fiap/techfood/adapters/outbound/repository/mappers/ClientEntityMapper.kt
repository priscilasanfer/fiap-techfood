package br.com.fiap.techfood.adapters.outbound.repository.mappers

import br.com.fiap.techfood.adapters.outbound.repository.entities.ClientEntity
import br.com.fiap.techfood.application.core.domains.Client
import org.springframework.stereotype.Component

@Component
class ClientEntityMapper {
    fun toClientDomain(clientEntity: ClientEntity): Client {
        return Client(
            id = clientEntity.id,
            cpf = clientEntity.cpf,
            name = clientEntity.name,
            email = clientEntity.email,
        )
    }

    fun toClientEntity(clientDomain: Client): ClientEntity {
        return ClientEntity(
            id= clientDomain.id,
            cpf = clientDomain.cpf,
            name = clientDomain.name,
            email = clientDomain.email
        )
    }
}