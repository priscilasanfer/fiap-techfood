package br.com.fiap.techfood.adapters.inbound.mappers

import br.com.fiap.techfood.adapters.dtos.ProductDTO
import br.com.fiap.techfood.core.application.domains.ProductDomain
import org.springframework.stereotype.Component

@Component
class ProductMapper {
    fun dtoToDomain(productDto: ProductDTO?): ProductDomain {
        if (productDto == null) {
            throw IllegalArgumentException("ProductDTO cannot be null")
        }

        return ProductDomain(
            name = productDto.name,
            description = productDto.description,
            price = productDto.price,
            category = productDto.category,
            imageURL = productDto.imageURL,
        )
    }

    fun domainToDto(product: ProductDomain?): ProductDTO {
        if (product == null) {
            throw IllegalArgumentException("ProductEntity cannot be null")
        }
        return ProductDTO(
            id = product.id,
            name = product.name,
            description = product.description,
            price = product.price,
            category = product.category,
            imageURL = product.imageURL,
        )
    }
}