package br.com.fiap.techfood.adapters.outbound

import br.com.fiap.techfood.adapters.outbound.repository.ProductRepository
import br.com.fiap.techfood.application.core.domain.Product
import br.com.fiap.techfood.application.ports.outbound.product.UpdateProductOutputPort

import org.springframework.stereotype.Service

@Service
class UpdateProductAdapter (
    private val productRepository: ProductRepository
) : UpdateProductOutputPort {
    override fun update(id: Long, updatedProduct: Product): Product {
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
}
