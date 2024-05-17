package br.com.fiap.techfood.adapters.outbound.repository.entities

import jakarta.persistence.Column
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table
import lombok.Data

@Entity
@Table(name = "TB_ORDER_ITEMS")
@Data
class OrderItemEntity {

    @EmbeddedId
    var id = OrderItemPk()

    @Column(nullable = false)
    var quantity: Int? = null

    var description: String? = null

    //TODO CHECAR SE VAI PRECISAR DESSES CAMPOS
    //private BigDecimal discount;
    //private BigDecimal price;
}
