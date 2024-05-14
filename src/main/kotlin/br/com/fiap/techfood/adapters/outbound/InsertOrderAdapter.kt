package br.com.fiap.techfood.adapters.outbound

import br.com.fiap.techfood.adapters.outbound.repository.OrderRepository
import br.com.fiap.techfood.adapters.outbound.repository.mappers.OrderEntityMapper
import br.com.fiap.techfood.application.core.domains.ClientDomain
import br.com.fiap.techfood.application.core.domains.Order
import br.com.fiap.techfood.application.ports.outbound.order.InsertOrderOutputPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class InsertOrderAdapter : InsertOrderOutputPort {
    @Autowired
    private val orderRepository: OrderRepository? = null

    @Autowired
    private val orderEntityMapper: OrderEntityMapper? = null

    override fun insert(order: Order?, client: ClientDomain?): Order? {
        var orderEntity = orderEntityMapper!!.toEntity(order)
        orderEntity = orderRepository!!.save(orderEntity)
        //TODO ENTITY -> PEDIDO
        return order
    }
}