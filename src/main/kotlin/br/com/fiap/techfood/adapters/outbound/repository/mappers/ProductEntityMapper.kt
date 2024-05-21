package br.com.fiap.techfood.adapters.outbound.repository.mappers

import br.com.fiap.techfood.adapters.outbound.repository.entities.ProductEntity
import br.com.fiap.techfood.core.application.domains.ProductDomain
import org.springframework.stereotype.Component

@Component
class ProductEntityMapper {
    fun toProductEntity(productDomain: ProductDomain): ProductEntity {
        return ProductEntity(
            id = productDomain.id,
            name = productDomain.name,
            description = productDomain.description,
            price = productDomain.price,
            category = productDomain.category,
            imageURL = productDomain.imageURL,
        )
    }

    fun toProductDomain(productEntity: ProductEntity): ProductDomain {
        return ProductDomain(
            id = productEntity.id,
            name = productEntity.name!!,
            description = productEntity.description!!,
            price = productEntity.price!!,
            category = productEntity.getCategory()!!,
            imageURL = productEntity.imageURL!!
        )
    }

}