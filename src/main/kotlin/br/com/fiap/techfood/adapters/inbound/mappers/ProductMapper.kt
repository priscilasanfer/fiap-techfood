package br.com.fiap.techfood.adapters.inbound.mappers

import br.com.fiap.techfood.adapters.dtos.ProductDTO
import br.com.fiap.techfood.adapters.outbound.repository.entities.ProductEntity
import br.com.fiap.techfood.application.core.domains.Product
import org.springframework.stereotype.Component

@Component
class ProductMapper {
    fun toProduct(productDto: ProductDTO?): Product {
        if (productDto == null) {
            throw IllegalArgumentException("ProductDTO cannot be null")
        }

        return Product(
            name = productDto.name,
            description = productDto.description,
            price = productDto.price,
            category = productDto.category,
            imageURL = productDto.imageURL,
        )
    }

    fun productToProductDto(product: Product?): ProductDTO {
        if (product == null) {
            throw IllegalArgumentException("ProductEntity cannot be null")
        }
        return ProductDTO(
            name = product.name,
            description = product.description,
            price = product.price,
            category = product.category,
            imageURL = product.imageURL,
        )
    }
}