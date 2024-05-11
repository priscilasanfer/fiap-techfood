package br.com.fiap.techfood.application.ports.outbound

import br.com.fiap.techfood.application.core.domains.Product

interface ProductOutboundPort {

    fun findAllByIds(ids: Set<Long?>?): List<Product?>

}
