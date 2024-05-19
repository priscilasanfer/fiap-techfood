package br.com.fiap.techfood.adapters.configs

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfiguration {

    @Bean
    fun springShopOpenAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Tech Food")
                    .description("Tech Food backend application")
            )
        // Vou deixar para referencia futura:
        //.externalDocs(
        //    ExternalDocumentation()
        //        .description("SpringShop Wiki Documentation")
        //        .url("https://springshop.wiki.github.org/docs")
        //)
    }

}