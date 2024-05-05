package br.com.fiap.techfood.application.ports.inbound.product

import br.com.fiap.techfood.application.core.domain.Product

interface InsertProductInputPort {
    fun insert(product: Product): Product
}