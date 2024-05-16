package br.com.fiap.techfood.application.core.usecases

import br.com.fiap.techfood.application.core.domains.Product
import br.com.fiap.techfood.application.core.domains.enums.CategoryEnum
import br.com.fiap.techfood.application.ports.inbound.ProductInboundPort
import br.com.fiap.techfood.application.ports.outbound.ProductOutboundPort
import java.util.*

class ProductUseCase(private var productOutboundPort: ProductOutboundPort) : ProductInboundPort {
    override fun save(product: Product): Product {
        return productOutboundPort.save(product)
    }

    override fun update(id: UUID, updatedProduct: Product) : Product {
        return productOutboundPort.update(id, updatedProduct)
    }

    override fun findById(id: UUID): Product {
        return productOutboundPort.findById(id)
    }

    override fun findByCategory(category: CategoryEnum): List<Product> {
        return productOutboundPort.findByCategory(category)
    }

    override fun findAll(): List<Product> {
        return productOutboundPort.findAll()
    }

    override fun delete(id: UUID){
        productOutboundPort.delete(id)
    }
}