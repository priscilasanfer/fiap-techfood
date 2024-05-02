package br.com.fiap.techfood.techfood.domain.dto

import br.com.fiap.techfood.techfood.domain.enums.CategoryEnum

data class ProductDTO(
    val name : String,
    val description : String,
    val price : String,
    val category : CategoryEnum,
    val imageURL : String,
)
