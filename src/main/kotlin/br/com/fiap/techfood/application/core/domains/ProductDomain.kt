package br.com.fiap.techfood.application.core.domains

import br.com.fiap.techfood.application.core.domains.enums.CategoryEnum
import java.math.BigDecimal
import java.util.*

data class ProductDomain (

    var id: UUID? = null,
    var name : String,
    var description : String,
    var price : BigDecimal,
    var category : CategoryEnum,
    var imageURL : String,

    )
