package br.com.fiap.techfood.adapters.config

import br.com.fiap.techfood.application.core.usercase.order.InsertOrderUserCase
import br.com.fiap.techfood.application.ports.outbound.order.InsertOrderOutputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InsertCustomerConfig {
    @Bean
    fun insertOrderUserCase(insertOrderOutputPort: InsertOrderOutputPort?): InsertOrderUserCase {
        return InsertOrderUserCase(insertOrderOutputPort!!)
    }
}
