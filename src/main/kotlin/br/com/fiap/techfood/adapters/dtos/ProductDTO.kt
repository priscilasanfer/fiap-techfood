package br.com.fiap.techfood.adapters.dtos

import br.com.fiap.techfood.application.core.domains.enums.CategoryEnum
import com.fasterxml.jackson.annotation.JsonView
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.util.UUID

data class ProductDTO(

    val id: UUID? = null,

    @field:NotBlank(groups = [ProductView.CreatePost::class, ProductView.UpdatePut::class])
    @JsonView(ProductView.CreatePost::class, ProductView.UpdatePut::class)
    val name: String,

    @field:NotBlank(groups = [ProductView.CreatePost::class, ProductView.UpdatePut::class])
    @JsonView(ProductView.CreatePost::class, ProductView.UpdatePut::class)
    val description: String,

    @field:NotNull(groups = [ProductView.CreatePost::class, ProductView.UpdatePut::class])
    val price: BigDecimal,

    @field:NotNull(groups = [ProductView.CreatePost::class, ProductView.UpdatePut::class])
    val category: CategoryEnum,

    @field:NotNull(groups = [ProductView.CreatePost::class, ProductView.UpdatePut::class])
    val imageURL: String,
) {
    interface ProductView {
        interface CreatePost
        interface UpdatePut
    }
}
