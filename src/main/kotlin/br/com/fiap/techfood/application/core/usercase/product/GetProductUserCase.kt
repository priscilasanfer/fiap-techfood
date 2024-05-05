package br.com.fiap.techfood.application.core.usercase.product

import br.com.fiap.techfood.application.core.domain.Product
import br.com.fiap.techfood.application.core.domain.enums.CategoryEnum
import br.com.fiap.techfood.application.ports.inbound.product.GetProductInputPort
import br.com.fiap.techfood.application.ports.outbound.product.GetProductOutputPort

class GetProductUserCase(private var getProductOutputPort: GetProductOutputPort) : GetProductInputPort {
    override fun get(id: Long): Product {
        return getProductOutputPort.get(id)
    }

    override fun getByCategory(category: CategoryEnum): List<Product> {
        return getProductOutputPort.getByCategory(category)
    }

    override fun getProducts(): List<Product> {
        return getProductOutputPort.getProducts()
    }
}