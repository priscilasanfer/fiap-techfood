package br.com.fiap.techfood.adapters.dtos

import br.com.fiap.techfood.application.core.domains.enums.CategoryEnum
import java.math.BigDecimal
import java.util.UUID

data class ProductDTO(

    val id: UUID? = null,
    val name: String,
    val description: String,
    val price: BigDecimal,
    val category: CategoryEnum,
    val imageURL: String,
) {

}
