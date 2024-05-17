package br.com.fiap.techfood.adapters.outbound

import br.com.fiap.techfood.adapters.outbound.repository.OrderItemRepository
import br.com.fiap.techfood.adapters.outbound.repository.OrderRepository
import br.com.fiap.techfood.adapters.outbound.repository.entities.OrderEntity
import br.com.fiap.techfood.adapters.outbound.repository.mappers.OrderEntityMapper
import br.com.fiap.techfood.application.core.domains.OrderDomain
import br.com.fiap.techfood.application.core.domains.enums.OrderStatusEnum
import br.com.fiap.techfood.application.ports.outbound.OrderOutboundPort
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class OrderAdapter : OrderOutboundPort {

    @Autowired
    private val orderRepository: OrderRepository? = null

    @Autowired
    private val orderItemRepository: OrderItemRepository? = null;

    @Autowired
    private val orderEntityMapper: OrderEntityMapper? = null


    @Transactional
    override fun save(orderDomain: OrderDomain): OrderDomain {
        var orderEntity = orderEntityMapper!!.toOrderEntity(orderDomain)
        orderEntity = orderRepository!!.save(orderEntity)

        val orderItemsEntity = orderEntityMapper.toOrderItemEntityList(orderDomain.items!!, orderEntity);
        orderEntity.items = orderItemsEntity;
        orderItemRepository!!.saveAll(orderItemsEntity);

        return orderEntityMapper.toOrderDomain(orderEntity)
    }

    override fun findById(id: UUID): Optional<OrderDomain> {
        val optional = orderRepository!!.findById(id)
        return optional.map { orderEntity: OrderEntity? -> orderEntityMapper!!.toOrderDomain(orderEntity!!) }
    }

    override fun findAllByOrderStatus(status: OrderStatusEnum): List<OrderDomain> {
        val orderEntityList = orderRepository!!.findAllByStatus(status.code)
        return orderEntityList.map { orderEntity: OrderEntity? -> orderEntityMapper!!.toOrderDomain(orderEntity!!) };
    }

    override fun delete(id: UUID) {
        orderRepository!!.deleteById(id)
    }

    override fun updateStatus(id: UUID, status: OrderStatusEnum) {
        val optOrderEntity = orderRepository!!.findById(id)
        if (optOrderEntity.isPresent) {
            val orderEntity = optOrderEntity.get()
            orderEntity.setStatus(status)
            orderRepository.save(orderEntity)
        }
    }

}
