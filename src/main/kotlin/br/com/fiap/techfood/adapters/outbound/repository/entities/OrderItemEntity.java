package br.com.fiap.techfood.adapters.outbound.repository.entities;

import br.com.fiap.techfood.application.core.domains.Product;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "TB_ORDER_ITEMS")
@Data
public class OrderItemEntity {

    @EmbeddedId
    private OrderItemPk id = new OrderItemPk();
    private Integer quantity;
    private String description;

    //TODO CHECAR SE VAI PRECISAR DESSES CAMPOS
    //private BigDecimal discount;
    //private BigDecimal price;

}
