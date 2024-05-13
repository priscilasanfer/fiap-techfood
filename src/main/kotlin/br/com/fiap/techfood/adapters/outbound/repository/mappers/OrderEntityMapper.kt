package br.com.fiap.techfood.adapters.outbound.repository.mappers

import br.com.fiap.techfood.adapters.outbound.repository.entities.OrderEntity
import br.com.fiap.techfood.application.core.domains.Order
import org.springframework.stereotype.Component

@Component
class OrderEntityMapper {
    fun toEntity(order: Order?): OrderEntity {
        val entity = OrderEntity()

        return entity
    }
}
