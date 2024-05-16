package br.com.fiap.techfood.application.core.usecases

import br.com.fiap.techfood.application.core.domains.ProductDomain
import br.com.fiap.techfood.application.core.domains.enums.CategoryEnum
import br.com.fiap.techfood.application.ports.inbound.ProductInboundPort
import br.com.fiap.techfood.application.ports.outbound.ProductOutboundPort
import java.util.*

class ProductUseCase(private var productOutboundPort: ProductOutboundPort) : ProductInboundPort {
    override fun save(product: ProductDomain): ProductDomain {
        return productOutboundPort.save(product)
    }

    override fun update(id: UUID, updatedProduct: ProductDomain) : ProductDomain {
        return productOutboundPort.update(id, updatedProduct)
    }

    override fun findById(id: UUID): ProductDomain {
        return productOutboundPort.findById(id)
    }

    override fun findByCategory(category: CategoryEnum): List<ProductDomain> {
        return productOutboundPort.findByCategory(category)
    }

    override fun findAll(): List<ProductDomain> {
        return productOutboundPort.findAll()
    }

    override fun delete(id: UUID){
        productOutboundPort.delete(id)
    }
}