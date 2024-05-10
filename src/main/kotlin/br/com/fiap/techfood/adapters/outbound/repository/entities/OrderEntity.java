package br.com.fiap.techfood.adapters.outbound.repository.entities;

import br.com.fiap.techfood.application.core.domains.enums.OrderStatusEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "TB_ORDERS")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer status;
    private Boolean isAnonymous;

    @OneToMany(mappedBy = "id.order")
    private List<OrderItemEntity> items;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    @Column(nullable = false)
    private LocalDateTime creationDate;

    @Column(nullable = false)
    private LocalDateTime lastUpdateDate;

    @PrePersist
    private void beforePersist() {
        this.creationDate = LocalDateTime.now();
        this.lastUpdateDate = LocalDateTime.now();
    }

    @PreUpdate
    private void beforeUpdate() {
        this.lastUpdateDate = LocalDateTime.now();
    }

    private OrderStatusEnum getStatus() {
        return OrderStatusEnum.toEnum(this.status);
    }

    private void setStatus(OrderStatusEnum status) {
        this.status = status.getCode();
    }


}
