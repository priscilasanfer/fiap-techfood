package br.com.fiap.techfood.adapters.config

import br.com.fiap.techfood.application.core.usercase.product.UpdateProductUserCase
import br.com.fiap.techfood.application.ports.outbound.product.UpdateProductOutputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UpdateProductConfig {
    @Bean
    fun updateProductUserCase(updateProductOutputPort: UpdateProductOutputPort): UpdateProductUserCase {
        return UpdateProductUserCase(updateProductOutputPort)
    }
}