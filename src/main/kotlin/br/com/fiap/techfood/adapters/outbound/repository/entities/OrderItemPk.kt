package br.com.fiap.techfood.adapters.outbound.repository.entities

import jakarta.persistence.Embeddable
import jakarta.persistence.ForeignKey
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.io.Serializable
import java.util.*

@Embeddable
class OrderItemPk(
    @ManyToOne
    @JoinColumn(name = "order_id",  foreignKey = ForeignKey(name = "fk_order_item_order"))
    var order: OrderEntity? = null,

    @ManyToOne
    @JoinColumn(name = "product_id",  foreignKey = ForeignKey(name = "fk_order_item_product"))
    var product: ProductEntity? = null
) : Serializable {

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as OrderItemPk
        return order == that.order && product == that.product
    }

    override fun hashCode(): Int {
        return Objects.hash(order, product)
    }
}
