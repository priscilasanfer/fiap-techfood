package br.com.fiap.techfood.adapters.outbound.repository.entities

import br.com.fiap.techfood.adapters.dtos.ProductDTO
import br.com.fiap.techfood.application.core.domains.enums.CategoryEnum
import jakarta.persistence.*
import java.math.BigDecimal
import java.util.*

@Entity
@Table(name = "products")
class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID

    @Column(nullable = false)
    var name: String

    @Column(nullable = false)
    var description: String

    @Column(nullable = false)
    var price: BigDecimal

    @Column(nullable = false)
    var category: CategoryEnum

    @Column(nullable = false)
    var imageURL: String

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
}