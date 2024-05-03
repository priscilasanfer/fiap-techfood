package br.com.fiap.techfood.adapters.dto

import br.com.fiap.techfood.application.core.domain.enums.CategoryEnum

data class ProductDTO(
    val name : String,
    val description : String,
    val price : String,
    val category : CategoryEnum,
    val imageURL : String,
)
