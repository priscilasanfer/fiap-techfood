package br.com.fiap.techfood.adapters.dtos

import org.jetbrains.annotations.NotNull

class OrderCreateDTO(

    @NotNull
    var orderItems: List<OrderItemDto>? = null,

    @NotNull
    var orderName: String? = null,

    var clientCpf: String? = null,
)
