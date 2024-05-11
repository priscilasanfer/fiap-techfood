package br.com.fiap.techfood.adapters.dtos

import br.com.fiap.techfood.application.core.domains.ClientDomain
import br.com.fiap.techfood.application.core.domains.OrderItemDomain
import br.com.fiap.techfood.application.core.domains.enums.OrderStatusEnum
import java.util.UUID

class OrderDto(

    val id: UUID? = null,
    var name: String? = null,
    var items: List<OrderItemDto>? = listOf(),
    var status: OrderStatusEnum? = null,
    var isAnonymous: Boolean? = null,
    var client: ClientDomain? = null,

    )
