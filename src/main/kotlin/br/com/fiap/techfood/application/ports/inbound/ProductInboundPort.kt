package br.com.fiap.techfood.application.ports.inbound

import br.com.fiap.techfood.application.core.domains.ProductDomain
import br.com.fiap.techfood.application.core.domains.enums.CategoryEnum
import java.util.*

interface ProductInboundPort {
    fun registerNewProduct(product: ProductDomain): ProductDomain
    fun updateProduct(id: UUID, updatedProduct: ProductDomain) : ProductDomain
    fun searchProductById(id: UUID): ProductDomain
    fun searchProductByCategory(category: CategoryEnum): List<ProductDomain>
    fun findAll(): List<ProductDomain>
    fun findAllByIds(ids: MutableSet<UUID>): List<ProductDomain>
    fun deleteProduct(id: UUID)
}