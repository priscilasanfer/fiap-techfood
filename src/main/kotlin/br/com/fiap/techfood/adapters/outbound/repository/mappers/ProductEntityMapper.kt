package br.com.fiap.techfood.adapters.outbound.repository.mappers

import br.com.fiap.techfood.adapters.outbound.repository.entities.ProductEntity
import br.com.fiap.techfood.application.core.domains.Product
import org.springframework.stereotype.Component

@Component
class ProductEntityMapper {
    fun toProductEntity(productDomain: Product): ProductEntity {
        return ProductEntity(
            id= productDomain.id,
            name= productDomain.name,
            description = productDomain.description,
            price= productDomain.price,
            category= productDomain.category,
            imageURL = productDomain.imageURL,
        )
    }

    fun toProduct(productEntity: ProductEntity): Product {
        return Product(
            name = productEntity.name,
            description = productEntity.description,
            price = productEntity.price,
            category = productEntity.category,
            imageURL = productEntity.imageURL
        )
    }
}