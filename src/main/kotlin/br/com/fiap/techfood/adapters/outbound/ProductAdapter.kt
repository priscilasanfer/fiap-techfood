package br.com.fiap.techfood.adapters.outbound

import br.com.fiap.techfood.application.core.domains.Product
import br.com.fiap.techfood.application.ports.outbound.ProductOutboundPort
import org.springframework.stereotype.Component

@Component
class ProductAdapter : ProductOutboundPort {

    //TODO
    override fun findAllByIds(ids: MutableSet<Long?>): List<Product> {
        return listOf<Product>()
    }

}
