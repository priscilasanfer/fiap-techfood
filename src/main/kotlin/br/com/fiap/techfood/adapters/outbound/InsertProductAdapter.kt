package br.com.fiap.techfood.adapters.outbound

import br.com.fiap.techfood.adapters.outbound.repository.ProductRepository
import br.com.fiap.techfood.adapters.outbound.repository.mapper.ProductEntityMapper
import br.com.fiap.techfood.application.core.domain.Product
import br.com.fiap.techfood.application.ports.outbound.product.InsertProductOutputPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class InsertProductAdapter : InsertProductOutputPort {
    @Autowired
    private val productRepository: ProductRepository? = null

    @Autowired
    private val productEntityMapper: ProductEntityMapper? = null

    override fun insert(product: Product): Product {
        var productEntity = productEntityMapper!!.toEntity(product)
        productEntity = productRepository!!.save(productEntity)
        //TODO ENTITY -> PEDIDO
        return product
    }
}