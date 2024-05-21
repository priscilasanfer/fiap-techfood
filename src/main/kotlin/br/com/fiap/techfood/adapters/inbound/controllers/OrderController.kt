package br.com.fiap.techfood.adapters.inbound.controllers

import br.com.fiap.techfood.adapters.dtos.OrderCreateDTO
import br.com.fiap.techfood.adapters.dtos.OrderDto
import br.com.fiap.techfood.adapters.inbound.mappers.CartMapper
import br.com.fiap.techfood.adapters.inbound.mappers.ClientMapper
import br.com.fiap.techfood.adapters.inbound.mappers.OrderMapper
import br.com.fiap.techfood.core.application.domains.CartDomain
import br.com.fiap.techfood.core.application.domains.ClientDomain
import br.com.fiap.techfood.core.application.domains.OrderDomain
import br.com.fiap.techfood.core.application.domains.enums.OrderStatusEnum
import br.com.fiap.techfood.core.ports.inbound.OrderInboundPort
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/orders")
class OrderController(
    private val orderInboundPort: OrderInboundPort,
    private val orderMapper: OrderMapper,
    private val clientMapper: ClientMapper,
    private val cartMapper: CartMapper
) {

    @PostMapping
    fun makeOrder(@RequestBody @Validated orderCreateDto: OrderCreateDTO): ResponseEntity<OrderDomain> {
        val cartDomain: CartDomain = cartMapper.toCartDomain(orderCreateDto);
        var clientDomain: ClientDomain? = null

        if (orderCreateDto.client != null) {
            clientDomain = clientMapper.toClientDomain(orderCreateDto.client!!);
        }

        val response = orderInboundPort.save(cartDomain, clientDomain)
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/awaiting-payment")
    fun findAllAwaitingPayment(): ResponseEntity<List<OrderDto>> {
        val orderDomainList = orderInboundPort.findAllByStatus(OrderStatusEnum.AWAITING_PAYMENT);
        val orderDtoList = orderDomainList.map { orderMapper.toOrderDto(it) }
        return ResponseEntity.ok().body(orderDtoList);
    }

    @GetMapping("/approved")
    fun findAllApprovedOrders(): ResponseEntity<List<OrderDto>> {
        val orderDomainList = orderInboundPort.findAllByStatus(OrderStatusEnum.PAYMENT_APPROVED);
        val orderDtoList = orderDomainList.map { orderMapper.toOrderDto(it) }
        return ResponseEntity.ok().body(orderDtoList);
    }

    @GetMapping("/prepared")
    fun findAllPreparedOrders(): ResponseEntity<List<OrderDto>> {
        val orderDomainList = orderInboundPort.findAllByStatus(OrderStatusEnum.PREPARED);
        val orderDtoList = orderDomainList.map { orderMapper.toOrderDto(it) }
        return ResponseEntity.ok().body(orderDtoList);
    }

    @GetMapping("/finished")
    fun findAllFinishedOrders(): ResponseEntity<List<OrderDto>> {
        val orderDomainList = orderInboundPort.findAllByStatus(OrderStatusEnum.FINISHED);
        val orderDtoList = orderDomainList.map { orderMapper.toOrderDto(it) }
        return ResponseEntity.ok().body(orderDtoList);
    }

    @DeleteMapping("/{orderId}")
    fun deleteOrder(@PathVariable orderId: UUID): ResponseEntity<Void> {
        orderInboundPort.delete(orderId);
        return ResponseEntity.noContent().build();
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
