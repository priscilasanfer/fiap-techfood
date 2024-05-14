package br.com.fiap.techfood.adapters.config

import br.com.fiap.techfood.application.core.usercase.InsertOrderUserCase
import br.com.fiap.techfood.application.ports.outbound.InsertOrderOutputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InsertCustomerConfig {
    @Bean
    fun insertOrderUserCase(insertOrderOutputPort: InsertOrderOutputPort?): InsertOrderUserCase {
        return InsertOrderUserCase(insertOrderOutputPort!!)
    }
}
