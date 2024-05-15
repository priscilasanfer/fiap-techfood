package br.com.fiap.techfood.adapters.inbound.mappers

import br.com.fiap.techfood.adapters.dtos.ClientDTO
import br.com.fiap.techfood.application.core.domains.Client
import org.springframework.stereotype.Component

@Component
class ClientMapper {
    fun toClientDomain(clientDTO: ClientDTO): Client {
        return Client(
            cpf = clientDTO.cpf,
            name = clientDTO.name,
            email = clientDTO.email,
        )
    }

    fun toClientDTO(clientDomain: Client): ClientDTO {
        return ClientDTO(
            cpf = clientDomain.cpf,
            name = clientDomain.name,
            email = clientDomain.email
        )
    }
}