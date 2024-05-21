package br.com.fiap.techfood.core.application.domains

import br.com.fiap.techfood.core.application.domains.enums.CategoryEnum
import java.math.BigDecimal
import java.util.*

data class ProductDomain(

    val id: UUID? = null,
    var name: String,
    var description: String,
    var price: BigDecimal,
    var category: CategoryEnum,
    var imageURL: String,

    )
