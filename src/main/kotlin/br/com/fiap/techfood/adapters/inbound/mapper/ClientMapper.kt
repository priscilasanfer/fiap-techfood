package br.com.fiap.techfood.adapters.inbound.mapper

import br.com.fiap.techfood.adapters.dto.ClientDTO
import br.com.fiap.techfood.application.core.domain.ClientDomain
import org.springframework.stereotype.Component

@Component
class ClientMapper {
    fun toClientDomain(clientDTO: ClientDTO): ClientDomain {
        return ClientDomain(
            cpf = clientDTO.cpf,
            name = clientDTO.name,
            email = clientDTO.email,
        )
    }

    fun toClientDTO(clientDomain: ClientDomain): ClientDTO {
        return ClientDTO(
            cpf = clientDomain.cpf,
            name = clientDomain.name,
            email = clientDomain.email
        )
    }
}