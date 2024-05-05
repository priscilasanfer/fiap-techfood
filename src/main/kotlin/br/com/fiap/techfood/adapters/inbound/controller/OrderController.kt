package br.com.fiap.techfood.adapters.inbound.controller

import br.com.fiap.techfood.adapters.dto.OrderDto
import br.com.fiap.techfood.adapters.inbound.mapper.OrderMapper
import br.com.fiap.techfood.application.core.domain.Order
import br.com.fiap.techfood.application.ports.inbound.InsertOrderInputPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/order")
class OrderController (
//    @Autowired private val insertOrderInputPort: InsertOrderInputPort,
//    @Autowired private val orderMapper: OrderMapper
) {

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
