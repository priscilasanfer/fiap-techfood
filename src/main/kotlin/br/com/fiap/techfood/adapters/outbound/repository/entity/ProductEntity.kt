package br.com.fiap.techfood.adapters.outbound.repository.entity

import br.com.fiap.techfood.adapters.dto.ProductDTO
import br.com.fiap.techfood.application.core.domain.enums.CategoryEnum
import jakarta.persistence.*
import java.math.BigDecimal
import java.util.UUID

@Entity
@Table(name = "products")
class ProductEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID = UUID(0,0),

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    var description: String,

    @Column(nullable = false)
    var price: BigDecimal,

    @Column(nullable = false)
    var category: CategoryEnum,

    @Column(nullable = false)
    var imageURL: String
)