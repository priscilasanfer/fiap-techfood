package br.com.fiap.techfood.adapters.inbound.mappers

import br.com.fiap.techfood.adapters.dtos.ClientDTO
import br.com.fiap.techfood.core.application.domains.ClientDomain
import org.springframework.stereotype.Component

@Component
class ClientMapper {
    fun toClientDomain(clientDTO: ClientDTO): ClientDomain {
        return ClientDomain(
            cpf = clientDTO.cpf!!,
            name = clientDTO.name!!,
            email = clientDTO.email!!,
        )
    }

    fun toClientDTO(clientDomain: ClientDomain): ClientDTO {
        return ClientDTO(
            cpf = clientDomain.cpf,
            name = clientDomain.name,
            email = clientDomain.email
        )
    }

    fun toClientResponseDTO(clientDomain: ClientDomain): ClientResponseDTO {
        return ClientResponseDTO(
            id = clientDomain.id,
            cpf = clientDomain.cpf,
            name = clientDomain.name,
            email = clientDomain.email

        )
    }
}