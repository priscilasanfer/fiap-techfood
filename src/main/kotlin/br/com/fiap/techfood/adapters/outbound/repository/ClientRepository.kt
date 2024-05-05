package br.com.fiap.techfood.adapters.outbound.repository

import br.com.fiap.techfood.adapters.outbound.repository.entity.ClientEntity
import br.com.fiap.techfood.application.core.domain.ClientDomain
import org.springframework.data.jpa.repository.JpaRepository

interface ClientRepository : JpaRepository<ClientEntity?, Long?>{
    fun save(client: ClientDomain): ClientDomain
}
