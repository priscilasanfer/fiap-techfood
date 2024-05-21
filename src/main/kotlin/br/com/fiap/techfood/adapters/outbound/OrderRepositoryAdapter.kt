package br.com.fiap.techfood.adapters.outbound

import br.com.fiap.techfood.adapters.outbound.repository.OrderItemRepository
import br.com.fiap.techfood.adapters.outbound.repository.OrderRepository
import br.com.fiap.techfood.adapters.outbound.repository.entities.OrderEntity
import br.com.fiap.techfood.adapters.outbound.repository.mappers.OrderEntityMapper
import br.com.fiap.techfood.core.application.domains.OrderDomain
import br.com.fiap.techfood.core.application.domains.enums.OrderStatusEnum
import br.com.fiap.techfood.core.ports.outbound.repositories.OrderRepositoryCore
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class OrderRepositoryAdapter(
    @Autowired
    private val orderRepository: OrderRepository,

    @Autowired
    private val orderItemRepository: OrderItemRepository,

    @Autowired
    private val orderEntityMapper: OrderEntityMapper
) : OrderRepositoryCore {


    @Transactional
    override fun save(orderDomain: OrderDomain): OrderDomain {
        var orderEntity = orderEntityMapper.toOrderEntity(orderDomain)
        orderEntity = orderRepository.save(orderEntity)

        val orderItemsEntity = orderEntityMapper.toOrderItemEntityList(orderDomain.items!!, orderEntity)
        orderEntity.items = orderItemsEntity
        orderItemRepository.saveAll(orderItemsEntity)

        return orderEntityMapper.toOrderDomain(orderEntity)
    }

    override fun findById(id: UUID): Optional<OrderDomain> {
        val optional = orderRepository.findById(id)
        return optional.map { orderEntity: OrderEntity? -> orderEntityMapper.toOrderDomain(orderEntity!!) }
    }

    override fun findAllByOrderStatus(status: OrderStatusEnum): List<OrderDomain> {
        val orderEntityList = orderRepository.findAllByStatus(status.code)
        return orderEntityList.map { orderEntity: OrderEntity? -> orderEntityMapper.toOrderDomain(orderEntity!!) }
    }

    override fun delete(id: UUID) {
        orderRepository.deleteById(id)
    }

    override fun updateStatus(id: UUID, status: OrderStatusEnum) {
        val optOrderEntity = orderRepository.findById(id)
        if (optOrderEntity.isPresent) {
            val orderEntity = optOrderEntity.get()
            orderEntity.setStatus(status)
            orderRepository.save(orderEntity)
        }
    }

}