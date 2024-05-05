package br.com.fiap.techfood.adapters.inbound.mapper

import br.com.fiap.techfood.adapters.dto.ProductDTO
import br.com.fiap.techfood.adapters.outbound.repository.entity.ProductEntity
import br.com.fiap.techfood.application.core.domain.Product
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

    fun productEntityToProduct(productEntity: ProductEntity?): Product {
        if (productEntity == null) {
            throw IllegalArgumentException("ProductEntity cannot be null")
        }
        return Product(
            name = productEntity.name,
            description = productEntity.description,
            price = productEntity.price,
            category = productEntity.category,
            imageURL = productEntity.imageURL,
        )
    }
}