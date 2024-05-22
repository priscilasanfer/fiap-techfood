package br.com.fiap.techfood.adapters.configs

import br.com.fiap.techfood.TechfoodApplication
import br.com.fiap.techfood.adapters.outbound.ClientRepositoryAdapter
import br.com.fiap.techfood.adapters.outbound.OrderRepositoryAdapter
import br.com.fiap.techfood.adapters.outbound.ProductRepositoryAdapter
import br.com.fiap.techfood.core.application.usecases.ClientUseCase
import br.com.fiap.techfood.core.application.usecases.OrderUserCase
import br.com.fiap.techfood.core.ports.outbound.repositories.ClientRepositoryCore
import br.com.fiap.techfood.core.application.usecases.ProductUseCase
import br.com.fiap.techfood.core.ports.outbound.repositories.ProductRepositoryCore
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackageClasses = [TechfoodApplication::class])
class BeanConfiguration {

    @Bean
    fun clientUseCase(persistence: ClientRepositoryCore): ClientUseCase {
        return ClientUseCase(persistence)
    }

    @Bean
    fun orderUserCase(
        orderRepositoryAdapter: OrderRepositoryAdapter,
        productRepositoryAdapter: ProductRepositoryAdapter,
        clientRepositoryAdapter: ClientRepositoryAdapter
    ): OrderUserCase {
        return OrderUserCase(orderRepositoryAdapter, productRepositoryAdapter, clientRepositoryAdapter);
    }

    @Bean
    fun productUseCase(persistence: ProductRepositoryCore): ProductUseCase {
        return ProductUseCase(persistence)
    }

}
