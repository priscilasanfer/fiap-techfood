package br.com.fiap.techfood.adapters.outbound.repository.mappers

import br.com.fiap.techfood.adapters.outbound.repository.entities.*
import br.com.fiap.techfood.core.application.domains.OrderDomain
import br.com.fiap.techfood.core.application.domains.OrderItemDomain
import org.springframework.stereotype.Component

@Component
class OrderEntityMapper(
    private val clientEntityMapper: ClientEntityMapper
) {

    fun toOrderEntity(orderDomain: OrderDomain): OrderEntity {
        val orderEntity = OrderEntity()
        orderEntity.setStatus(orderDomain.status);
        orderEntity.isAnonymous = orderDomain.isAnonymous;
        orderEntity.name = orderDomain.name
        return orderEntity;
    }

    fun toOrderDomain(orderEntity: OrderEntity): OrderDomain {
        val orderDomain = OrderDomain();
        orderDomain.id = orderEntity.id
        //
        orderDomain.items = toOrderItemDomainList(orderEntity.items)
        orderDomain.status = orderEntity.getStatus()!!;
        orderDomain.isAnonymous = orderEntity.isAnonymous;
        orderDomain.name = orderEntity.name

        if (orderEntity.client?.id != null) {
            orderDomain.client = clientEntityMapper.toClientDomain(orderEntity.client!!);
        }

        return orderDomain;
    }

    fun toOrderItemEntityList(orderItemDomain: List<OrderItemDomain>, orderEntity: OrderEntity): List<OrderItemEntity> {
        return orderItemDomain.map {
            toOrderItemEntity(it, orderEntity);
        }
    }

    fun toOrderItemEntity(orderItemDomain: OrderItemDomain, orderEntity: OrderEntity): OrderItemEntity {
        val orderItemEntity = OrderItemEntity();
        orderItemEntity.id = OrderItemPk(orderEntity, ProductEntity(orderItemDomain.productId!!));
        orderItemEntity.quantity = orderItemDomain.quantity;
        orderItemEntity.description = orderItemDomain.description;
        return orderItemEntity;
    }

    fun toOrderItemDomainList(orderItemEntityList: List<OrderItemEntity>): List<OrderItemDomain> {
        return orderItemEntityList.map {
            toOrderItemDomain(it);
        }
    }

    fun toOrderItemDomain(orderItemEntity: OrderItemEntity): OrderItemDomain {
        val orderItemDomain = OrderItemDomain();
        orderItemDomain.productId = orderItemEntity.id.product!!.id;
        orderItemDomain.quantity = orderItemEntity.quantity;
        orderItemDomain.description = orderItemEntity.description;
        return orderItemDomain;
    }
}
