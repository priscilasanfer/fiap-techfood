package br.com.fiap.techfood.application.ports.outbound.product

import br.com.fiap.techfood.application.core.domain.Product
import br.com.fiap.techfood.application.core.domain.enums.CategoryEnum

interface GetProductOutputPort {
    fun get(id: Long): Product

    fun getByCategory(category: CategoryEnum): List<Product>

    fun getProducts(): List<Product>
}