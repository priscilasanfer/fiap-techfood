package br.com.fiap.techfood.application.ports.inbound.product

import br.com.fiap.techfood.application.core.domain.Product

interface UpdateProductInputPort {
    fun update(id: Long, updatedProduct: Product) : Product
}