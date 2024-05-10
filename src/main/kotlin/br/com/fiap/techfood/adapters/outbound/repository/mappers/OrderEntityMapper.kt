package br.com.fiap.techfood.adapters.outbound.repository.mappers

import br.com.fiap.techfood.adapters.outbound.repository.entities.OrderEntity
import br.com.fiap.techfood.application.core.domains.OrderDomain
import org.springframework.stereotype.Component

@Component
class OrderEntityMapper {

    fun toEntity(order: OrderDomain?): OrderEntity {
        val entity = OrderEntity()

        return entity
    }

    fun toDomain(order: OrderEntity?): OrderDomain {
        val domain = OrderDomain();

        return domain;
    }
}
