package br.com.fiap.techfood.adapters.inbound.mappers

import br.com.fiap.techfood.adapters.dtos.ProductCreateDTO
import br.com.fiap.techfood.adapters.dtos.ProductDTO
import br.com.fiap.techfood.application.core.domains.ProductDomain
import org.springframework.stereotype.Component

@Component
class ProductMapper {
    fun toProductDomain(productDto: ProductDTO?): ProductDomain {
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

    fun toProductDomain(productCreateDTO: ProductCreateDTO?): ProductDomain {
        if (productCreateDTO == null) {
            throw IllegalArgumentException("ProductDTO cannot be null")
        }

        return ProductDomain(
            name = productCreateDTO.name,
            description = productCreateDTO.description,
            price = productCreateDTO.price,
            category = productCreateDTO.category,
            imageURL = productCreateDTO.imageURL,
        )
    }

    fun toProductDto(product: ProductDomain?): ProductDTO {
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
