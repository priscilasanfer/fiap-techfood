package br.com.fiap.techfood.adapters.outbound.repository.entities

import br.com.fiap.techfood.application.core.domains.enums.CategoryEnum
import jakarta.persistence.*
import java.math.BigDecimal
import java.util.*

@Entity
@Table(name = "TB_PRODUCTS")
class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null

    @Column(nullable = false)
    var name: String? = null

    @Column(nullable = false)
    var description: String? = null

    @Column(nullable = false)
    var price: BigDecimal? = null

    @Column(nullable = false)
    var category: Int? = null

    @Column(nullable = false)
    var imageURL: String? = null

    constructor() {
    }

    constructor(id: UUID) : this() {
        this.id = id;
    }

    constructor(id: UUID?, name: String, description: String, price: BigDecimal, category: CategoryEnum, imageURL: String) : this() {
        this.id = id
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category.id;
        this.imageURL = imageURL;
    }

    fun getCategory(): CategoryEnum? {
        return CategoryEnum.toEnum(this.category)
    }

    fun setCategory(category: CategoryEnum) {
        this.category = category.id
    }

}
