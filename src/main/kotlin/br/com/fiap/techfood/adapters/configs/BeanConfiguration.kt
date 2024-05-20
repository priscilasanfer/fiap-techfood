package br.com.fiap.techfood.adapters.configs

import br.com.fiap.techfood.TechfoodApplication
import br.com.fiap.techfood.adapters.outbound.OrderAdapter
import br.com.fiap.techfood.adapters.outbound.ProductAdapter
import br.com.fiap.techfood.adapters.outbound.ValidateCpfAdapter
import br.com.fiap.techfood.application.core.usecases.ClientUseCase
import br.com.fiap.techfood.application.core.usecases.OrderUserCase
import br.com.fiap.techfood.application.ports.outbound.ClientOutboundPort
import br.com.fiap.techfood.application.core.usecases.ProductUseCase
import br.com.fiap.techfood.application.ports.outbound.ProductOutboundPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackageClasses = [TechfoodApplication::class])
class BeanConfiguration {

    @Bean
    fun clientUseCase(persistence: ClientOutboundPort): ClientUseCase {
        return ClientUseCase(persistence)
    }

    @Bean
    fun orderUserCase(
        validateCpfAdapter: ValidateCpfAdapter,
        orderAdapter: OrderAdapter,
        productAdapter: ProductAdapter
    ): OrderUserCase {
        return OrderUserCase(validateCpfAdapter, orderAdapter, productAdapter);
    }

    @Bean
    fun productUseCase(persistence: ProductOutboundPort): ProductUseCase {
        return ProductUseCase(persistence)
    }

}
