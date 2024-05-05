package br.com.fiap.techfood.application.core.usercase.product

import br.com.fiap.techfood.application.core.domain.Product
import br.com.fiap.techfood.application.ports.inbound.product.InsertProductInputPort
import br.com.fiap.techfood.application.ports.outbound.product.InsertProductOutputPort

class InsertProductUserCase(private var insertProductOutputPort: InsertProductOutputPort) : InsertProductInputPort {
    override fun insert(product: Product): Product {
        return insertProductOutputPort.insert(product)
    }
}