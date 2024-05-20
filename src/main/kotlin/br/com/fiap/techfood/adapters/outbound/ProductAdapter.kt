package br.com.fiap.techfood.adapters.outbound

import br.com.fiap.techfood.adapters.outbound.repository.ProductRepository
import br.com.fiap.techfood.adapters.outbound.repository.mappers.ProductEntityMapper
import br.com.fiap.techfood.application.core.domains.ProductDomain
import br.com.fiap.techfood.application.core.domains.enums.CategoryEnum
import br.com.fiap.techfood.application.ports.outbound.ProductOutboundPort
import org.springframework.stereotype.Component
import java.util.Optional
import java.util.UUID

@Component
class ProductAdapter(
    private val productRepository: ProductRepository,
    private val productEntityMapper: ProductEntityMapper
) :
    ProductOutboundPort {

    override fun save(product: ProductDomain): ProductDomain {
        val productEntity = productEntityMapper.toProductEntity(product)
        val newProductEntity = productRepository.save(productEntity)
        return productEntityMapper.toProductDomain(newProductEntity)
    }

    override fun update(id: UUID, updatedProduct: ProductDomain): ProductDomain {
        var productEntity = productEntityMapper.toProductEntity(updatedProduct)
        productEntity = productRepository.save(productEntity)
        return productEntityMapper.toProductDomain(productEntity)
    }

    override fun findById(id: UUID): Optional<ProductDomain> {
        return productRepository.findById(id).map { this.productEntityMapper.toProductDomain(it) }
    }

    override fun findByCategory(category: CategoryEnum): List<ProductDomain> {
        val productEntities = productRepository.findByCategory(category.id)
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

    override fun delete(id: UUID) {
        productRepository.deleteById(id)
    }

    override fun findAllByIds(ids: MutableSet<UUID>): List<ProductDomain> {
        return productRepository.findAllById(ids).map { productEntityMapper.toProductDomain(it!!) };
    }
}
