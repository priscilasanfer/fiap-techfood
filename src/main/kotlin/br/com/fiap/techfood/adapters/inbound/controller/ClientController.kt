package br.com.fiap.techfood.adapters.inbound.controller

import br.com.fiap.techfood.adapters.dto.ClientDTO
import br.com.fiap.techfood.application.core.domain.ClientDomain
import br.com.fiap.techfood.application.ports.inbound.ClientInboundPort
import jakarta.validation.Valid
import org.modelmapper.ModelMapper
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/clients")
class ClientController(
    private var clientInboundPort: ClientInboundPort,
    private var mapper: ModelMapper
) {
    @PostMapping
    fun save(@RequestBody @Valid clientDTO: ClientDTO): ResponseEntity<ClientDTO> {
        val customerDomain = mapper.map(clientDTO, ClientDomain::class.java)
        val customer = clientInboundPort.save(customerDomain)
        val responseDTO = mapper.map(customer, ClientDTO::class.java)
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO)
    }
}

