package br.com.fiap.techfood.application.ports.outbound

import br.com.fiap.techfood.application.core.domains.ClientDomain
import br.com.fiap.techfood.application.core.domains.PageInfo
import java.util.*

interface ClientOutboundPort {
    fun save(clientDomain: ClientDomain): ClientDomain
    fun findById(id: UUID): Optional<ClientDomain>
    fun findByCpf(cpf: String): Optional<ClientDomain>
    fun findAll(pageInfo: PageInfo): List<ClientDomain>
    fun delete(clientDomain: ClientDomain)
}
