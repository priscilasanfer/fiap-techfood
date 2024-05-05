package br.com.fiap.techfood.application.ports.inbound

import br.com.fiap.techfood.application.core.domain.ClientDomain
import br.com.fiap.techfood.application.core.domain.PageInfo
import java.util.*

interface ClientInboundPort {
    fun save(clientDomain: ClientDomain): ClientDomain
    fun findById(id: UUID): Optional<ClientDomain>
    fun findAll(pageInfo: PageInfo): List<ClientDomain>
}
