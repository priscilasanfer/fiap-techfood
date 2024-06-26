package br.com.fiap.techfood.adapters.dtos

import br.com.fiap.techfood.core.application.domains.enums.CategoryEnum
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.util.UUID

class ProductDTO(
    val id: UUID? = null,
    val name: String,
    val description: String,
    val price: BigDecimal,
    val category: CategoryEnum,
    val imageURL: String,
)
