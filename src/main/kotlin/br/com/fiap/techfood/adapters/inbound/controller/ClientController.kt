package br.com.fiap.techfood.adapters.inbound.controller

import br.com.fiap.techfood.adapters.dto.ClientDTO
import br.com.fiap.techfood.adapters.inbound.mapper.ClientMapper
import br.com.fiap.techfood.application.ports.inbound.ClientInboundPort
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/clients")
class ClientController(
    private var clientInboundPort: ClientInboundPort,
    private var clientMapper: ClientMapper

) {
    @PostMapping
    fun save(@RequestBody @Valid clientDTO: ClientDTO): ResponseEntity<ClientDTO> {
        val clientDomain = clientMapper.toOrderDomain(clientDTO)
        val clientDomainSaved = clientInboundPort.save(clientDomain)
        val clientDTOSaved = clientMapper.toClientDTO(clientDomainSaved)
        return ResponseEntity.status(HttpStatus.CREATED).body(clientDTOSaved)
    }
}

