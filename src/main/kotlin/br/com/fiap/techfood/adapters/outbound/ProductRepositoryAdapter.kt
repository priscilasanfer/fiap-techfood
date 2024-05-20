package br.com.fiap.techfood.adapters.outbound

import br.com.fiap.techfood.adapters.outbound.repository.ProductRepository
import br.com.fiap.techfood.adapters.outbound.repository.mappers.ProductEntityMapper
import br.com.fiap.techfood.core.application.domains.ProductDomain
import br.com.fiap.techfood.core.application.domains.enums.CategoryEnum
import br.com.fiap.techfood.core.ports.outbound.repositories.ProductRepositoryCore
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class ProductRepositoryAdapter(
    private val productRepository: ProductRepository,
    private val productEntityMapper: ProductEntityMapper
) :
    ProductRepositoryCore {

    @Transactional
    override fun save(product: ProductDomain): ProductDomain {
        val productEntity = productEntityMapper.toProductEntity(product)
        val newProductEntity = productRepository.save(productEntity)
        return productEntityMapper.toProductDomain(newProductEntity)
    }

    override fun findById(id: UUID): ProductDomain {
        val productEntity = productRepository.findById(id).orElseThrow()
        return productEntityMapper.toProductDomain(productEntity!!)
    }

    override fun findByCategory(category: CategoryEnum): List<ProductDomain> {
        val productEntities = productRepository.findByCategory(category)
        return productEntities.map { productEntity ->
            productEntityMapper.toProductDomain(productEntity)
        }
    }

    override fun findAll(): List<ProductDomain> {
        val productEntities = productRepository.findAll()
        return productEntities.map { productEntity ->
            productEntityMapper.toProductDomain(productEntity!!)
        }
    }

    @Transactional
    override fun delete(id: UUID) {
        productRepository.deleteById(id)
    }

    override fun findAllByIds(ids: MutableSet<UUID>): List<ProductDomain> {
        return productRepository.findAllById(ids).map { productEntityMapper.toProductDomain(it!!) };
    }
}
