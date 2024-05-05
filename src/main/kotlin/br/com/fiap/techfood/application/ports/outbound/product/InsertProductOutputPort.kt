package br.com.fiap.techfood.application.ports.outbound.product

import br.com.fiap.techfood.application.core.domain.Product

interface InsertProductOutputPort {
    fun insert(product: Product): Product
}
