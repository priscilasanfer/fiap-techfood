package br.com.fiap.techfood.application.core.domain

import br.com.fiap.techfood.application.core.domain.enums.CategoryEnum
import java.math.BigDecimal

data class Product (

    val name : String,
    val description : String,
    val price : BigDecimal,
    val category : CategoryEnum,
    val imageURL : String,

    )