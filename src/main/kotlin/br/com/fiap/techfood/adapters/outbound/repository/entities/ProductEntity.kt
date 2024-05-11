package br.com.fiap.techfood.adapters.outbound.repository.entities

import br.com.fiap.techfood.adapters.dtos.ProductDTO
import br.com.fiap.techfood.application.core.domains.enums.CategoryEnum
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal

@Entity
class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
    var name: String? = null
    var description: String? = null
    var price: BigDecimal? = null
    var category: CategoryEnum? = null
    var imageURL: String? = null

    constructor() {

    }

    constructor(id: Long) : this() {
        this.id = id;
    }

    constructor(name: String, description: String, price: BigDecimal, category: CategoryEnum, imageURL: String) : this() {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.imageURL = imageURL;
    }

    //fun toProduct() = ProductDTO(this.name, this.description, this.price, this.category, this.imageURL)
}