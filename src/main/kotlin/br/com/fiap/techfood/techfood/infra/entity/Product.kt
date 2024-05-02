package br.com.fiap.techfood.techfood.infra.entity

import br.com.fiap.techfood.techfood.domain.dto.ProductDTO
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: Long = 0,
    private val name: String,
    private val description: String,
    private var price: String
) {
    constructor(name: String, description: String, price: String) : this(0, name, description, price)
    fun toProduct() = ProductDTO(this.name, this.description, this.price)
}