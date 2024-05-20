package br.com.fiap.techfood.application.core.usecases

import br.com.fiap.techfood.application.core.domains.ProductDomain
import br.com.fiap.techfood.application.core.domains.enums.CategoryEnum
import br.com.fiap.techfood.application.core.domains.exceptions.ObjectNotFoundException
import br.com.fiap.techfood.application.ports.inbound.ProductInboundPort
import br.com.fiap.techfood.application.ports.outbound.ProductOutboundPort
import java.util.*

class ProductUseCase(private var productOutboundPort: ProductOutboundPort) : ProductInboundPort {

    override fun save(product: ProductDomain): ProductDomain {
        product.id = null;
        return productOutboundPort.save(product)
    }

    override fun update(id: UUID, updatedProduct: ProductDomain): ProductDomain {
        val productDomain = this.findById(id)
        productDomain.name = updatedProduct.name
        productDomain.description = updatedProduct.description
        productDomain.price = updatedProduct.price
        productDomain.category = updatedProduct.category
        productDomain.imageURL = updatedProduct.imageURL
        return productOutboundPort.update(id, updatedProduct)
    }

    override fun findById(id: UUID): ProductDomain {
        val productDomainOpt = productOutboundPort.findById(id)
        if (productDomainOpt.isEmpty) {
            throw ObjectNotFoundException("Product with $id not found.")
        }
        return productDomainOpt.get();
    }

    override fun findByCategory(category: CategoryEnum): List<ProductDomain> {
        return productOutboundPort.findByCategory(category)
    }

    override fun findAll(): List<ProductDomain> {
        return productOutboundPort.findAll()
    }

    override fun delete(id: UUID) {
        this.findById(id);
        productOutboundPort.delete(id)
    }
}