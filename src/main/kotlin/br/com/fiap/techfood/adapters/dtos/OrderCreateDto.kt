package br.com.fiap.techfood.adapters.dtos

import org.jetbrains.annotations.NotNull

class OrderCreateDto {

    @NotNull
    var cart: CartDTO? = null
    var client: ClientDTO? = null

    @NotNull
    var orderName: String? = null;

}
