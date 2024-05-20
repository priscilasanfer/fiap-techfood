package br.com.fiap.techfood.application.core.usecases

import br.com.fiap.techfood.application.core.domains.ProductDomain
import br.com.fiap.techfood.application.core.domains.enums.CategoryEnum
import br.com.fiap.techfood.application.ports.inbound.ProductInboundPort
import br.com.fiap.techfood.application.ports.outbound.ProductOutboundPort
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductUseCase(
    private var productOutboundPort: ProductOutboundPort
) : ProductInboundPort {

    override fun registerNewProduct(product: ProductDomain): ProductDomain {
        return productOutboundPort.save(product)
    }

    override fun updateProduct(id: UUID, updatedProduct: ProductDomain): ProductDomain {
        var existingProduct = productOutboundPort.findById(id)

        existingProduct.name = updatedProduct.name
        existingProduct.description = updatedProduct.description
        existingProduct.price = updatedProduct.price
        existingProduct.category= updatedProduct.category
        existingProduct.imageURL = updatedProduct.imageURL

        val productUpdated = productOutboundPort.save(existingProduct)
        return productUpdated
    }

    override fun searchProductById(id: UUID): ProductDomain {
        return productOutboundPort.findById(id)
    }

    override fun searchProductByCategory(category: CategoryEnum): List<ProductDomain> {
        return productOutboundPort.findByCategory(category)
    }

    override fun findAll(): List<ProductDomain> {
        return productOutboundPort.findAll()
    }

    override fun deleteProduct(id: UUID) {
        productOutboundPort.delete(id)
    }

    override fun findAllByIds(ids: MutableSet<UUID>): List<ProductDomain> {
        return productOutboundPort.findAllByIds(ids)
    }
}