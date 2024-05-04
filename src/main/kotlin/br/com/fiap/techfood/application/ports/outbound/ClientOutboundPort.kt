package br.com.fiap.techfood.application.ports.outbound

import br.com.fiap.techfood.application.core.domain.ClientDomain

interface ClientOutboundPort {
    fun save(client: ClientDomain): ClientDomain
}