package br.com.fiap.techfood.adapters.dtos

import lombok.Data
import java.util.*

@Data
class OrderItemDto {
    var productId: UUID? = null
    var quantity: Int? = null
    var description: String? = null
}
