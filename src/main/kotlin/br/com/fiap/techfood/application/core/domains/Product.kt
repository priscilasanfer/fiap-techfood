package br.com.fiap.techfood.application.core.domains

import br.com.fiap.techfood.application.core.domains.enums.CategoryEnum
import java.math.BigDecimal
import java.util.UUID

data class Product (

    val id: UUID,
    val name : String,
    val description : String,
    val price : BigDecimal,
    val category : CategoryEnum,
    val imageURL : String,

    )