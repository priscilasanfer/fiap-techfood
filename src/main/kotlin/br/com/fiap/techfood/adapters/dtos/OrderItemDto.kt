package br.com.fiap.techfood.adapters.dtos

import lombok.Data
import java.util.*

@Data
class OrderItemDto {
    val productId: UUID? = null
    val quantity: Int? = null
    val description: String? = null
}
