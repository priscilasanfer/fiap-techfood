package br.com.fiap.techfood.application.core.domains

import br.com.fiap.techfood.application.core.domains.enums.CategoryEnum
import java.math.BigDecimal
import java.util.*

data class Product (

    val id: UUID = UUID(0,0),
    var name : String,
    var description : String,
    var price : BigDecimal,
    var category : CategoryEnum,
    var imageURL : String,

    )