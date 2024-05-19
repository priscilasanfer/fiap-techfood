package br.com.fiap.techfood.adapters.outbound.repository

import br.com.fiap.techfood.adapters.outbound.repository.entities.ClientEntity
import br.com.fiap.techfood.application.core.domains.Client
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ClientRepository : JpaRepository<ClientEntity?, Long?> {
    fun save(client: Client): ClientEntity
    fun findById(id: UUID): Optional<ClientEntity>
    fun findByCpf(cpf: String): Optional<ClientEntity>
}
