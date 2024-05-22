package br.com.fiap.techfood.adapters.outbound.repository

import br.com.fiap.techfood.adapters.outbound.repository.entities.OrderEntity
import br.com.fiap.techfood.adapters.outbound.repository.entities.OrderItemEntity
import br.com.fiap.techfood.adapters.outbound.repository.entities.OrderItemPk
import org.springframework.data.jpa.repository.JpaRepository

interface OrderItemRepository : JpaRepository<OrderItemEntity, OrderItemPk> {

    fun findAllByIdOrder(category: OrderEntity): List<OrderItemEntity>

}
