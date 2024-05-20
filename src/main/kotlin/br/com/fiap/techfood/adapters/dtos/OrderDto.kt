package br.com.fiap.techfood.adapters.dtos

import br.com.fiap.techfood.core.application.domains.ClientDomain
import br.com.fiap.techfood.core.application.domains.enums.OrderStatusEnum
import java.util.UUID

class OrderDto(

    var id: UUID? = null,
    var name: String? = null,
    var items: List<OrderItemDto>? = listOf(),
    var status: OrderStatusEnum? = null,
    var isAnonymous: Boolean? = null,
    var client: ClientDomain? = null,

    )
