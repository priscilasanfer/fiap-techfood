package br.com.fiap.techfood.application.core.usercase.product

import br.com.fiap.techfood.application.core.domain.Product
import br.com.fiap.techfood.application.ports.inbound.product.UpdateProductInputPort
import br.com.fiap.techfood.application.ports.outbound.product.UpdateProductOutputPort

class UpdateProductUserCase(private var updateProductOutputPort: UpdateProductOutputPort) : UpdateProductInputPort {
    override fun update(id: Long, updatedProduct: Product) : Product {
        return updateProductOutputPort.update(id, updatedProduct)
    }
}