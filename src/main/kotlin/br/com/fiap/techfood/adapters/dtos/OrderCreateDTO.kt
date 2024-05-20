package br.com.fiap.techfood.adapters.dtos

import org.jetbrains.annotations.NotNull

class OrderCreateDTO (
    @NotNull
    var cart: CartDTO? = null,

    @NotNull
    var orderName: String? = null,

    var client: ClientDTO? = null,
)
