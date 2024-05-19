package br.com.fiap.techfood.application.ports.inbound

import br.com.fiap.techfood.application.core.domains.Client
import br.com.fiap.techfood.application.core.domains.PageInfo
import java.util.*


interface ClientInboundPort {
    fun save(clientDomain: Client): Client
    fun findById(id: UUID): Optional<Client>
    fun findByCpf(cpf: String): Optional<Client>
    fun findAll(pageInfo: PageInfo): List<Client>
    fun delete(clientDomain: Client)
}
