package br.com.fiap.techfood.adapters.dtos

import br.com.fiap.techfood.application.core.domains.enums.CategoryEnum
import com.fasterxml.jackson.annotation.JsonInclude
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

@JsonInclude(JsonInclude.Include.NON_NULL)
class ProductCreateDTO(
    @NotBlank
    val name: String,

    @NotBlank
    val description: String,

    @NotNull
    val price: BigDecimal,

    @NotNull
    val category: CategoryEnum,

    @NotBlank

    val imageURL: String,
)
