package br.com.fiap.techfood.adapters.outbound.repository.mapper

import br.com.fiap.techfood.adapters.outbound.repository.entity.ProductEntity
import br.com.fiap.techfood.application.core.domain.Product
import org.springframework.stereotype.Component

@Component
class ProductEntityMapper {
    fun toEntity(product: Product): ProductEntity {
        val category = product.category
        val description = product.description
        val imageURL = product.imageURL
        val name = product.name
        val price = product.price

        val entity = ProductEntity(category = category, description = description, imageURL = imageURL, name = name, price = price)
        return entity
    }

}