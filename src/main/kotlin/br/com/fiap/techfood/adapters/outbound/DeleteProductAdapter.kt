package br.com.fiap.techfood.adapters.outbound

import br.com.fiap.techfood.adapters.outbound.repository.ProductRepository
import br.com.fiap.techfood.application.ports.outbound.product.DeleteProductOutputPort
import org.springframework.stereotype.Service

@Service
class DeleteProductAdapter (
    private val productRepository: ProductRepository
    ) : DeleteProductOutputPort {

    override fun delete(id: Long) {
        productRepository.deleteById(id)
    }
}
