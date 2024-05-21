package br.com.fiap.techfood.core.application.usecases

import br.com.fiap.techfood.core.application.domains.ProductDomain
import br.com.fiap.techfood.core.application.domains.enums.CategoryEnum
import br.com.fiap.techfood.core.application.domains.exceptions.ObjectNotFoundException
import br.com.fiap.techfood.core.ports.inbound.ProductInboundPort
import br.com.fiap.techfood.core.ports.outbound.repositories.ProductRepositoryCore
import java.util.*

class ProductUseCase(
    private var productRepositoryCore: ProductRepositoryCore
) : ProductInboundPort {

    override fun registerNewProduct(product: ProductDomain): ProductDomain {
        product.id = null;
        return productRepositoryCore.save(product)
    }

    override fun updateProduct(id: UUID, updatedProduct: ProductDomain): ProductDomain {
        val productDomain = this.searchProductById(id)
        productDomain.name = updatedProduct.name
        productDomain.description = updatedProduct.description
        productDomain.price = updatedProduct.price
        productDomain.category = updatedProduct.category
        productDomain.imageURL = updatedProduct.imageURL
        return productRepositoryCore.save(updatedProduct)
    }

    override fun searchProductById(id: UUID): ProductDomain {
        val productDomainOpt = productRepositoryCore.findById(id)
        if (productDomainOpt.isEmpty) {
            throw ObjectNotFoundException("Product with $id not found.")
        }
        return productDomainOpt.get();
    }

    override fun searchProductByCategory(category: CategoryEnum): List<ProductDomain> {
        return productRepositoryCore.findByCategory(category)
    }

    override fun findAll(): List<ProductDomain> {
        return productRepositoryCore.findAll()
    }

    override fun deleteProduct(id: UUID) {
        this.searchProductById(id);
        productRepositoryCore.delete(id)
    }

    override fun findAllByIds(ids: MutableSet<UUID>): List<ProductDomain> {
        return productRepositoryCore.findAllByIds(ids)
    }
}