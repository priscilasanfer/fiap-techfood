package br.com.fiap.techfood.core.application.usecases

import br.com.fiap.techfood.core.application.domains.ProductDomain
import br.com.fiap.techfood.core.application.domains.enums.CategoryEnum
import br.com.fiap.techfood.core.application.domains.exceptions.ObjectNotFoundException
import br.com.fiap.techfood.core.application.usecases.mappers.ProductMapperCore
import br.com.fiap.techfood.core.ports.inbound.ProductInboundPort
import br.com.fiap.techfood.core.ports.outbound.repositories.ProductRepositoryCore
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductUseCase(
    private var repository: ProductRepositoryCore,
    private var mapper: ProductMapperCore
) : ProductInboundPort {

    override fun registerNewProduct(product: ProductDomain): ProductDomain {
        product.id = null;
        return repository.save(product)
    }

    override fun updateProduct(id: UUID, productToUpdate: ProductDomain): ProductDomain {
        val productDomain = this.searchProductById(id)
        val updatedProduct = mapper.domainToUpdated(productDomain, productToUpdate)
        return repository.save(updatedProduct)
    }

    override fun searchProductById(id: UUID): ProductDomain {
        val productDomainOpt = repository.findById(id)
        if (productDomainOpt.isEmpty) {
            throw ObjectNotFoundException("Product with $id not found.")
        }
        return productDomainOpt.get();
    }

    override fun searchProductByCategory(category: CategoryEnum): List<ProductDomain> {
        return repository.findByCategory(category)
    }

    override fun findAll(): List<ProductDomain> {
        return repository.findAll()
    }

    override fun deleteProduct(id: UUID) {
        this.searchProductById(id);
        repository.delete(id)
    }

    override fun findAllByIds(ids: MutableSet<UUID>): List<ProductDomain> {
        return repository.findAllByIds(ids)
    }
}