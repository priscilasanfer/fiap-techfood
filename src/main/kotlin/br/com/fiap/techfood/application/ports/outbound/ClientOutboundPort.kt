package br.com.fiap.techfood.application.ports.outbound

import br.com.fiap.techfood.application.core.domains.ClientDomain
import br.com.fiap.techfood.application.core.domains.PageInfo
import org.springframework.data.domain.Pageable
import java.util.*

interface ClientOutboundPort {
    fun save(clientDomain: ClientDomain): ClientDomain
    fun findById(id: UUID): Optional<ClientDomain>
    fun findByCpf(cpf: String): Optional<ClientDomain>
    fun findAll(pageable: Pageable): List<ClientDomain>
    fun delete(clientDomain: ClientDomain)
}
