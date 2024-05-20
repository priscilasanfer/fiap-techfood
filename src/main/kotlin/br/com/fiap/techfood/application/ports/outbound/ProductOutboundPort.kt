package br.com.fiap.techfood.application.ports.outbound

import br.com.fiap.techfood.application.core.domains.ProductDomain
import br.com.fiap.techfood.application.core.domains.enums.CategoryEnum
import java.util.*

interface ProductOutboundPort {
    fun save(product: ProductDomain): ProductDomain
    fun findById(id: UUID): ProductDomain
    fun findByCategory(category: CategoryEnum): List<ProductDomain>
    fun findAll(): List<ProductDomain>
    fun delete(id: UUID)
    fun findAllByIds(ids: MutableSet<UUID>): List<ProductDomain>
}
