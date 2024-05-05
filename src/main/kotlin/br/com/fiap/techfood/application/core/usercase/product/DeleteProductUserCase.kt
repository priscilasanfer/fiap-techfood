package br.com.fiap.techfood.application.core.usercase.product

import br.com.fiap.techfood.application.ports.inbound.product.DeleteProductInputPort
import br.com.fiap.techfood.application.ports.outbound.product.DeleteProductOutputPort

class DeleteProductUserCase(private var deleteProductOutputPort: DeleteProductOutputPort) : DeleteProductInputPort {
    override fun delete(id: Long){
        deleteProductOutputPort.delete(id)
    }
}