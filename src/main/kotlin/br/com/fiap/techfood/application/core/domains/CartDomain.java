package br.com.fiap.techfood.application.core.domains;

import java.util.List;
import java.util.UUID;

public class CartDomain {

    private UUID id;
    private List<OrderItem> cartProducts;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<OrderItem> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(List<OrderItem> cartProducts) {
        this.cartProducts = cartProducts;
    }

}
