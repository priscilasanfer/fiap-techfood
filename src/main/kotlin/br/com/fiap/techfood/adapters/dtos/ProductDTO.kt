package br.com.fiap.techfood.adapters.dtos

import br.com.fiap.techfood.core.application.domains.enums.CategoryEnum
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.util.UUID

data class ProductDTO(

    val id: UUID? = null,

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
