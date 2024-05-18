package br.com.fiap.techfood.adapters.outbound.repository.entities

import br.com.fiap.techfood.application.core.domains.enums.OrderStatusEnum
import jakarta.persistence.*
import lombok.Data
import java.time.LocalDateTime
import java.util.*

@Data
@Entity
@Table(name = "TB_ORDERS")
class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null

    @Column(nullable = false)
    var name: String? = null

    @Column(nullable = false)
    private var status: Int? = null

    public fun getStatus(): OrderStatusEnum? {
        return OrderStatusEnum.toEnum(this.status)
    }

    public fun setStatus(status: OrderStatusEnum) {
        this.status = status.code
    }

    var isAnonymous: Boolean? = null

    @OneToMany(mappedBy = "id.order")
    var items: List<OrderItemEntity> = listOf();

    @ManyToOne
    @JoinColumn(name = "client_id", foreignKey = ForeignKey(name = "fk_order_client"))
    var client: ClientEntity? = null

    @Column(nullable = false)
    var creationDate: LocalDateTime? = null

    @Column(nullable = false)
    var lastUpdateDate: LocalDateTime? = null

    @PrePersist
    private fun beforePersist() {
        this.creationDate = LocalDateTime.now()
        this.lastUpdateDate = LocalDateTime.now()
    }

    @PreUpdate
    private fun beforeUpdate() {
        this.lastUpdateDate = LocalDateTime.now()
    }
}
