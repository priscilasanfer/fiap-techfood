package br.com.fiap.techfood.adapters.outbound.repository

import br.com.fiap.techfood.adapters.outbound.repository.entities.OrderEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface OrderRepository : JpaRepository<OrderEntity, UUID> {

    fun findAllByStatus(status: Int?): List<OrderEntity>

}
