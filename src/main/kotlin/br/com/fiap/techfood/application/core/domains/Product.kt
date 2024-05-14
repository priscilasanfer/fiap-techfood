package br.com.fiap.techfood.application.core.domains

import br.com.fiap.techfood.application.core.domains.enums.CategoryEnum
import java.math.BigDecimal

data class Product (

    val name : String,
    val description : String,
    val price : BigDecimal,
    val category : CategoryEnum,
    val imageURL : String,

    )