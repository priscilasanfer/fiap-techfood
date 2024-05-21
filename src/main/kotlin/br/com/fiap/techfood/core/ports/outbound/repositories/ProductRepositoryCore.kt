package br.com.fiap.techfood.core.ports.outbound.repositories

import br.com.fiap.techfood.core.application.domains.ProductDomain
import br.com.fiap.techfood.core.application.domains.enums.CategoryEnum
import java.util.*

interface ProductRepositoryCore {
    fun save(product: ProductDomain): ProductDomain
    fun findById(id: UUID): ProductDomain
    fun findByCategory(category: CategoryEnum): List<ProductDomain>
    fun findAll(): List<ProductDomain>
    fun delete(id: UUID)
    fun findAllByIds(ids: MutableSet<UUID>): List<ProductDomain>
}
