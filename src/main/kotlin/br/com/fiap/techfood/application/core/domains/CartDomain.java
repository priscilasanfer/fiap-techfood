package br.com.fiap.techfood.application.core.domains;

import java.util.List;
import java.util.UUID;

public class CartDomain {

    private UUID id;
    private List<OrderItemDomain> cartProducts;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<OrderItemDomain> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(List<OrderItemDomain> cartProducts) {
        this.cartProducts = cartProducts;
    }

}
