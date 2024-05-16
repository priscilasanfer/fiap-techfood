package br.com.fiap.techfood.application.ports.inbound

import br.com.fiap.techfood.application.core.domains.ProductDomain
import br.com.fiap.techfood.application.core.domains.enums.CategoryEnum
import java.util.*

interface ProductInboundPort {
    fun save(product: ProductDomain): ProductDomain
    fun update(id: UUID, updatedProduct: ProductDomain) : ProductDomain
    fun findById(id: UUID): ProductDomain
    fun findByCategory(category: CategoryEnum): List<ProductDomain>
    fun findAll(): List<ProductDomain>
    fun delete(id: UUID)
}