package br.com.fiap.techfood.adapters.outbound.repository.mappers

import br.com.fiap.techfood.adapters.outbound.repository.entities.*
import br.com.fiap.techfood.application.core.domains.OrderDomain
import br.com.fiap.techfood.application.core.domains.OrderItemDomain
import org.springframework.stereotype.Component

@Component
class OrderEntityMapper {

    fun toOrderEntity(orderDomain: OrderDomain): OrderEntity {
        val orderEntity = OrderEntity()
        orderEntity.items = toOrderItemEntityList(orderDomain.items!!, orderEntity)
        orderEntity.setStatus(orderDomain.status);
        orderEntity.isAnonymous = orderDomain.isAnonymous;

        if (orderDomain.isAnonymous!! && orderDomain.client != null) {
            orderEntity.client = ClientEntity(orderDomain.id!!);
        }

        return orderEntity;
    }

    fun toOrderDomain(order: OrderEntity?): OrderDomain {
        val domain = OrderDomain();

        return domain;
    }

    fun toOrderItemEntityList(orderItemDomain: List<OrderItemDomain>, orderEntity: OrderEntity): List<OrderItemEntity> {
        return orderItemDomain.map {
            toOrderItemEntity(it, orderEntity);
        }
    }

    fun toOrderItemEntity(orderItemDomain: OrderItemDomain, orderEntity: OrderEntity): OrderItemEntity {
        var orderItemEntity = OrderItemEntity();
        orderItemEntity.id = OrderItemPk(orderEntity, ProductEntity(orderItemDomain.productId!!));
        orderItemEntity.quantity = orderItemDomain.quantity;
        orderItemEntity.description = orderItemDomain.description;
        return orderItemEntity;
    }
}
