package br.com.fiap.techfood.core.application.usecases.mappers

import br.com.fiap.techfood.core.application.domains.ProductDomain
import org.springframework.stereotype.Component

@Component
class ProductMapperCore {

    fun domainToUpdated(domain: ProductDomain, toUpdate: ProductDomain): ProductDomain {
        return ProductDomain(
            domain.id,
            toUpdate.name ?: domain.name,
            toUpdate.description ?: domain.description,
            toUpdate.price ?: domain.price,
            toUpdate.category ?: domain.category,
            toUpdate.imageURL ?: domain.imageURL
        )
    }
}