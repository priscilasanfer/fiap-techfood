package br.com.fiap.techfood.adapters.inbound.controllers

import br.com.fiap.techfood.adapters.dtos.OrderCreateDto
import br.com.fiap.techfood.adapters.dtos.OrderDto
import br.com.fiap.techfood.adapters.inbound.mappers.CartMapper
import br.com.fiap.techfood.adapters.inbound.mappers.ClientMapper
import br.com.fiap.techfood.adapters.inbound.mappers.OrderMapper
import br.com.fiap.techfood.core.application.domains.CartDomain
import br.com.fiap.techfood.core.application.domains.ClientDomain
import br.com.fiap.techfood.core.application.domains.OrderDomain
import br.com.fiap.techfood.core.ports.inbound.OrderInboundPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/orders")
class OrderController(
    @Autowired private val orderInboundPort: OrderInboundPort,
    @Autowired private val orderMapper: OrderMapper,
    @Autowired private val clientMapper: ClientMapper,
    @Autowired private val cartMapper: CartMapper
) {

    @PostMapping
    fun makeOrder(@RequestBody @Validated orderCreateDto: OrderCreateDto): ResponseEntity<OrderDomain> {
        val cartDomain: CartDomain = cartMapper.toCartDomain(orderCreateDto);
        var clientDomain: ClientDomain? = null

        if (orderCreateDto.client != null) {
            clientDomain = clientMapper.toClientDomain(orderCreateDto.client!!);
        }

        val response = orderInboundPort.save(cartDomain, clientDomain)
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/approved")
    fun findAllApprovedOrders(): ResponseEntity<List<OrderDto>> {
        val orderDomainList = orderInboundPort.findAllApprovedOrders();
        val orderDtoList = orderDomainList.map { orderMapper.toOrderDto(it) }
        return ResponseEntity.ok().body(orderDtoList);
    }

    @GetMapping("/prepared")
    fun findAllPreparedOrders(): ResponseEntity<List<OrderDto>> {
        val orderDomainList = orderInboundPort.findAllPrepared();
        val orderDtoList = orderDomainList.map { orderMapper.toOrderDto(it) }
        return ResponseEntity.ok().body(orderDtoList);
    }

    @DeleteMapping("/{orderId}")
    fun deleteOrder(@PathVariable orderId: UUID) {
        orderInboundPort.delete(orderId);
    }

    @PostMapping("/{orderId}/pay")
    fun approvePayment(@PathVariable orderId: UUID): ResponseEntity<String> {
        val message = orderInboundPort.approvePayment(orderId);
        return ResponseEntity.ok().body(message)
    }

    @PostMapping("/{orderId}/prepare")
    fun prepareOrder(@PathVariable orderId: UUID) {
        orderInboundPort.prepareOrder(orderId);
    }

    @PostMapping("/{orderId}/finish")
    fun finishOrder(@PathVariable orderId: UUID) {
        orderInboundPort.finishOrder(orderId);
    }


}
