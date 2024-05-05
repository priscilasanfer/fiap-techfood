package br.com.fiap.techfood.application.ports.inbound.product

import br.com.fiap.techfood.application.core.domain.Product
import br.com.fiap.techfood.application.core.domain.enums.CategoryEnum
import java.util.*

interface GetProductInputPort {
    fun get(id: Long): Product

    fun getByCategory(category: CategoryEnum): List<Product>

    fun getProducts(): List<Product>
}