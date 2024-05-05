package br.com.fiap.techfood.adapters.dto

import br.com.fiap.techfood.application.core.domain.enums.CategoryEnum
import java.math.BigDecimal

data class ProductDTO(
    val name : String,
    val description : String,
    val price : BigDecimal,
    val category : CategoryEnum,
    val imageURL : String,
)
