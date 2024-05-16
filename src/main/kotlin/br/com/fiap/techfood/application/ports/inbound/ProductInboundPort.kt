package br.com.fiap.techfood.application.ports.inbound

import br.com.fiap.techfood.application.core.domains.Product
import br.com.fiap.techfood.application.core.domains.enums.CategoryEnum
import java.util.*

interface ProductInboundPort {
    fun save(product: Product): Product
    fun update(id: UUID, updatedProduct: Product) : Product
    fun findById(id: UUID): Product
    fun findByCategory(category: CategoryEnum): List<Product>
    fun findAll(): List<Product>
    fun delete(id: UUID)
}