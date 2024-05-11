package br.com.fiap.techfood.adapters.dtos;

import java.util.List;
import java.util.UUID;

public class CartDTO {

    private UUID id;
    private List<OrderItemDto> cartProducts;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<OrderItemDto> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(List<OrderItemDto> cartProducts) {
        this.cartProducts = cartProducts;
    }
}
