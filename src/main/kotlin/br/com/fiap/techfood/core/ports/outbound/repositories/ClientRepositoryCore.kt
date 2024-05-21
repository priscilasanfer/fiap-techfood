package br.com.fiap.techfood.core.ports.outbound.repositories

import br.com.fiap.techfood.core.application.domains.ClientDomain
import br.com.fiap.techfood.core.application.domains.PageInfo
import java.util.*

interface ClientRepositoryCore {
    fun save(clientDomain: ClientDomain): ClientDomain
    fun findById(id: UUID): Optional<ClientDomain>
    fun findByCpf(cpf: String): Optional<ClientDomain>
    fun findAll(pageInfo: PageInfo): List<ClientDomain>
    fun delete(clientDomain: ClientDomain)
}
