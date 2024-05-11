package br.com.fiap.techfood.adapters.inbound.controllers

import br.com.fiap.techfood.adapters.dtos.OrderCreateDto
import br.com.fiap.techfood.adapters.inbound.mappers.CartMapper
import br.com.fiap.techfood.adapters.inbound.mappers.ClientMapper
import br.com.fiap.techfood.adapters.inbound.mappers.OrderMapper
import br.com.fiap.techfood.application.core.domains.ClientDomain
import br.com.fiap.techfood.application.ports.inbound.InsertOrderInputPort
import br.com.fiap.techfood.application.ports.inbound.OrderInboundPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/order")
class OrderController (
    @Autowired private val orderInboundPort: OrderInboundPort,
    @Autowired private val orderMapper: OrderMapper,
    @Autowired private val clientMapper: ClientMapper,
    @Autowired private val cartMapper: CartMapper
) {

    @PostMapping
    fun makeOrder(orderCreateDto: OrderCreateDto): ResponseEntity<Void> {
        val cartDomain = cartMapper.toCartDomain(orderCreateDto.cart);
        var clientDomain: ClientDomain? = null

        if(orderCreateDto.client != null) {
            clientDomain = clientMapper.toClientDomain(orderCreateDto.client!!);
        }

        orderInboundPort.save(cartDomain, clientDomain)
        return ResponseEntity.ok().build();
    }

    //TODO @Valid
//    @PostMapping
//    fun insert(@RequestBody orderDto: OrderDto?): ResponseEntity<Void> {
//        val order: Order = orderMapper.toOrder(orderDto)
//
//        TODO
//        insertOrderInputPort.insert(order, null)
//        return ResponseEntity.ok().build<Void>()
//    }
}
