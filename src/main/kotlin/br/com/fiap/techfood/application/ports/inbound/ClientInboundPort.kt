package br.com.fiap.techfood.application.ports.inbound

import br.com.fiap.techfood.application.core.domains.ClientDomain
import br.com.fiap.techfood.application.core.domains.PageInfo
import java.util.*

interface ClientInboundPort {
    fun save(clientDomain: ClientDomain): ClientDomain
    fun findById(id: UUID): Optional<ClientDomain>
    fun findAll(pageInfo: PageInfo): List<ClientDomain>
    fun delete(clientDomain: ClientDomain)
}
