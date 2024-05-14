package br.com.fiap.techfood.adapters.inbound.controllers

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
