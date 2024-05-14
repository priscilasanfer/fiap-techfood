package br.com.fiap.techfood.adapters.dtos

import br.com.fiap.techfood.application.core.domains.enums.CategoryEnum
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class ProductDTO(
    @NotNull
    val name : String,

    @NotNull
    val description : String,

    @NotNull
    val price : BigDecimal,

    @NotNull
    val category : CategoryEnum,

    @NotNull
    val imageURL : String,
)
