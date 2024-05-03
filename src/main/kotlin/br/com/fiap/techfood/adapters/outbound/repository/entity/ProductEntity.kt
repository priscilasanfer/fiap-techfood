package br.com.fiap.techfood.adapters.outbound.repository.entity

import br.com.fiap.techfood.adapters.dto.ProductDTO
import br.com.fiap.techfood.application.core.domain.enums.CategoryEnum
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class ProductEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: Long = 0,
    private val name: String,
    private val description: String,
    private val price: String,
    private val category: CategoryEnum,
    private val imageURL: String,

    ) {
    constructor(name: String, description: String, price: String, category: CategoryEnum, imageURL: String ) : this(0, name, description, price, category, imageURL) {}
    fun toProduct() = ProductDTO(this.name, this.description, this.price, this.category, this.imageURL)
}