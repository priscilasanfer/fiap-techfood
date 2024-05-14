package br.com.fiap.techfood.adapters.configs

import br.com.fiap.techfood.TechfoodApplication
import br.com.fiap.techfood.application.core.usecases.ClientUseCase
import br.com.fiap.techfood.application.ports.outbound.ClientOutboundPort
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

}
