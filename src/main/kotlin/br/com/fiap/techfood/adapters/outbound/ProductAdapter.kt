package br.com.fiap.techfood.adapters.outbound

import br.com.fiap.techfood.adapters.outbound.repository.ProductRepository
import br.com.fiap.techfood.adapters.outbound.repository.mappers.ProductEntityMapper
import br.com.fiap.techfood.application.core.domains.Product
import br.com.fiap.techfood.application.ports.outbound.ProductOutboundPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ProductAdapter : ProductOutboundPort {

    @Autowired
    val productRepository: ProductRepository? = null ;

    @Autowired
    val productEntityMapper: ProductEntityMapper? = null;


    //TODO
    override fun findAllByIds(ids: MutableSet<Long?>): List<Product> {
        return productRepository!!.findAllById(ids).map {  productEntityMapper!!.toProductDomain(it!!)};
    }

}
