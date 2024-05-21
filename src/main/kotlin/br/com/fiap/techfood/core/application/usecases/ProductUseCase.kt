package br.com.fiap.techfood.core.application.usecases

import br.com.fiap.techfood.core.application.domains.ProductDomain
import br.com.fiap.techfood.core.application.domains.enums.CategoryEnum
import br.com.fiap.techfood.core.ports.inbound.ProductInboundPort
import br.com.fiap.techfood.core.ports.outbound.repositories.ProductRepositoryCore
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductUseCase(
    private var productRepositoryCore: ProductRepositoryCore
) : ProductInboundPort {

    override fun registerNewProduct(product: ProductDomain): ProductDomain {
        return productRepositoryCore.save(product)
    }

    override fun updateProduct(id: UUID, updatedProduct: ProductDomain): ProductDomain {
        var existingProduct = productRepositoryCore.findById(id)

        existingProduct.name = updatedProduct.name
        existingProduct.description = updatedProduct.description
        existingProduct.price = updatedProduct.price
        existingProduct.category= updatedProduct.category
        existingProduct.imageURL = updatedProduct.imageURL

        val productUpdated = productRepositoryCore.save(existingProduct)
        return productUpdated
    }

    override fun searchProductById(id: UUID): ProductDomain {
        return productRepositoryCore.findById(id)
    }

    override fun searchProductByCategory(category: CategoryEnum): List<ProductDomain> {
        return productRepositoryCore.findByCategory(category)
    }

    override fun findAll(): List<ProductDomain> {
        return productRepositoryCore.findAll()
    }

    override fun deleteProduct(id: UUID) {
        productRepositoryCore.delete(id)
    }

    override fun findAllByIds(ids: MutableSet<UUID>): List<ProductDomain> {
        return productRepositoryCore.findAllByIds(ids)
    }
}