package br.com.fiap.techfood.adapters.config

import br.com.fiap.techfood.application.core.usercase.product.DeleteProductUserCase
import br.com.fiap.techfood.application.ports.outbound.product.DeleteProductOutputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DeleteProductConfig {
    @Bean
    fun deleteProductUserCase(deleteProductOutputPort: DeleteProductOutputPort): DeleteProductUserCase {
        return DeleteProductUserCase(deleteProductOutputPort)
    }
}