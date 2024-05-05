package br.com.fiap.techfood.application.ports.inbound

import br.com.fiap.techfood.application.core.domain.ClientDomain

interface ClientInboundPort {
    fun save(clientDomain: ClientDomain): ClientDomain
}
