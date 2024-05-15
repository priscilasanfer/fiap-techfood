package br.com.fiap.techfood.application.ports.outbound

import br.com.fiap.techfood.application.core.domains.Client
import br.com.fiap.techfood.application.core.domains.PageInfo
import java.util.*

interface ClientOutboundPort {
    fun save(clientDomain: Client): Client
    fun findById(id: UUID): Optional<Client>
    fun findAll(pageInfo: PageInfo): List<Client>
    fun delete(clientDomain: Client)
}
