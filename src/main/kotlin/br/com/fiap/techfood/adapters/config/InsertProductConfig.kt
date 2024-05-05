package br.com.fiap.techfood.adapters.config

import br.com.fiap.techfood.application.core.usercase.product.InsertProductUserCase
import br.com.fiap.techfood.application.ports.outbound.product.InsertProductOutputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InsertProductConfig {
    @Bean
    fun insertProductUserCase(insertProductOutputPort: InsertProductOutputPort): InsertProductUserCase {
        return InsertProductUserCase(insertProductOutputPort)
    }
}