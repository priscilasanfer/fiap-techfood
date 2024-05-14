package br.com.fiap.techfood.adapters.dtos

import br.com.fiap.techfood.application.core.domains.enums.CategoryEnum

data class ProductDTO(
    val name : String,
    val description : String,
    val price : String,
    val category : CategoryEnum,
    val imageURL : String,
)
