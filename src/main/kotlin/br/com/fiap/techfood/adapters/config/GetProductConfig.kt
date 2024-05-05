package br.com.fiap.techfood.adapters.config

import br.com.fiap.techfood.application.core.usercase.product.GetProductUserCase
import br.com.fiap.techfood.application.ports.outbound.product.GetProductOutputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GetProductConfig {
    @Bean
    fun getProductUserCase(getProductOutputPort: GetProductOutputPort): GetProductUserCase {
        return GetProductUserCase(getProductOutputPort)
    }
}