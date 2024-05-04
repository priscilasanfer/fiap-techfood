package br.com.fiap.techfood.adapters.configs

import br.com.fiap.techfood.TechfoodApplication
import br.com.fiap.techfood.application.ports.inbound.ClientInboundPort
import br.com.fiap.techfood.application.core.usercase.ClientUseCase
import org.modelmapper.ModelMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration


@Configuration
@ComponentScan(basePackageClasses = [TechfoodApplication::class])
class BeanConfiguration {
//Nova versão
    @Bean
    fun clientServicePortImpl(persistence: ClientInboundPort): ClientUseCase {
        return ClientUseCase(persistence)
    }


    @Bean
    fun modelMapper(): ModelMapper {
        return ModelMapper()
    }
}





