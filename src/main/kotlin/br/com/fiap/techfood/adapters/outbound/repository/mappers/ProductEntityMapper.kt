package br.com.fiap.techfood.adapters.outbound.repository.mappers

import br.com.fiap.techfood.adapters.outbound.repository.entities.ProductEntity
import br.com.fiap.techfood.application.core.domains.Product
import org.springframework.stereotype.Component

@Component
class ProductEntityMapper {

    fun toProductEntity(product: Product): ProductEntity {
        val productEntity = ProductEntity();
        productEntity.category = product.category;

        productEntity.category = product.category
        productEntity.description = product.description
        productEntity.imageURL = product.imageURL
        productEntity.name = product.name
        productEntity.price = product.price

        return productEntity
    }

    fun toProductDomain(productEntity: ProductEntity): Product {
        val product = Product();
        product.category = productEntity.category!!;

        product.category = productEntity.category!!
        product.description = productEntity.description!!
        product.imageURL = productEntity.imageURL!!
        product.name = productEntity.name!!
        product.price = productEntity.price!!

        return product
    }
    /*
    fun toEntity(product: Product): ProductEntity {
        val category = product.category
        val description = product.description
        val imageURL = product.imageURL
        val name = product.name
        val price = product.price

        val entity = ProductEntity(category = category, description = description, imageURL = imageURL, name = name, price = price)
        return entity
    }

     */

}