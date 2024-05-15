package br.com.fiap.techfood.adapters.outbound

import br.com.fiap.techfood.adapters.outbound.repository.ProductRepository
import br.com.fiap.techfood.adapters.outbound.repository.mappers.ProductEntityMapper
import br.com.fiap.techfood.application.core.domains.Product
import br.com.fiap.techfood.application.core.domains.enums.CategoryEnum
import br.com.fiap.techfood.application.ports.outbound.ProductOutboundPort
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class ProductAdapter (
    private val productRepository: ProductRepository,
    private val productEntityMapper: ProductEntityMapper
) :
    ProductOutboundPort {
    override fun save(product: Product): Product {
        val productEntity = productEntityMapper.toProductEntity(product)
        val newProductEntity = productRepository.save(productEntity)
        return productEntityMapper.toProduct(newProductEntity)
    }

    override fun update(id: UUID, updatedProduct: Product): Product {
        val existingProduct = productRepository.findById(id).orElseThrow {
            IllegalArgumentException("Product with ID $id not found")
        }

        existingProduct!!.name = updatedProduct.name
        existingProduct.description = updatedProduct.description
        existingProduct.price = updatedProduct.price
        existingProduct.category = updatedProduct.category
        existingProduct.imageURL = updatedProduct.imageURL

        val updatedEntity = productRepository.save(existingProduct)

        return Product(
            name = updatedEntity.name,
            description = updatedEntity.description,
            price = updatedEntity.price,
            category = updatedEntity.category,
            imageURL = updatedEntity.imageURL
        )
    }

    override fun findById(id: UUID): Product {
        val productEntity = productRepository.findById(id).orElseThrow()

        return productEntityMapper.toProduct(productEntity!!)
    }

    override fun findByCategory(category: CategoryEnum): List<Product> {
        val productEntities = productRepository.findByCategory(category)
        return productEntities.map { productEntity ->
            productEntityMapper.toProduct(productEntity)
        }
    }

    override fun findAll(): List<Product> {
        val productEntities = productRepository.findAll()
        return productEntities.map { productEntity ->
            productEntityMapper.toProduct(productEntity!!)
        }
    }

    override fun delete(id: UUID) {
        productRepository.deleteById(id)
    }
}
