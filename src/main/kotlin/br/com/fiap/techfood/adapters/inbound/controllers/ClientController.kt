package br.com.fiap.techfood.adapters.inbound.controllers

import br.com.fiap.techfood.adapters.dtos.ClientDTO
import br.com.fiap.techfood.adapters.dtos.ClientResponseDTO
import br.com.fiap.techfood.adapters.inbound.mappers.ClientMapper
import br.com.fiap.techfood.core.application.domains.PageInfo
import br.com.fiap.techfood.core.ports.inbound.ClientInboundPort
import org.springframework.beans.BeanUtils
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("/clients")
class ClientController(
    private val clientInboundPort: ClientInboundPort, private val clientMapper: ClientMapper

) {
    @PostMapping
    fun save(@RequestBody @Validated clientDTO: ClientDTO): ResponseEntity<ClientResponseDTO> {
        val clientDomain = clientMapper.toClientDomain(clientDTO)
        val clientDomainSaved = clientInboundPort.save(clientDomain)
        val clientDTOSaved = clientMapper.toClientResponseDTO(clientDomainSaved)
        return ResponseEntity.status(HttpStatus.CREATED).body(clientDTOSaved)
    }

    @GetMapping("/{clientId}")
    fun findById(@PathVariable(value = "clientId") clientId: UUID): ResponseEntity<Any> {
        val clientDomainOptional = clientInboundPort.findById(clientId)

        if (clientDomainOptional.isEmpty) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found.")
        }

        val clientDTO = clientMapper.toClientResponseDTO(clientDomainOptional.get())

        return ResponseEntity.status(HttpStatus.OK).body(clientDTO)
    }

    @GetMapping
    fun findAllClients(
        @PageableDefault(page = 0, size = 10, direction = Sort.Direction.ASC) pageable: Pageable?
    ): ResponseEntity<Page<ClientResponseDTO>> {
        val pageInfo = PageInfo()
        BeanUtils.copyProperties(pageable!!, pageInfo)

        val clientDomainList = clientInboundPort.findAll(pageInfo)

        val clientDTOList = clientDomainList.map { domain -> clientMapper.toClientResponseDTO(domain) }

        return ResponseEntity.status(HttpStatus.OK).body<Page<ClientResponseDTO>>(
            PageImpl<ClientResponseDTO>(
                clientDTOList, pageable, clientDomainList.size.toLong()
            )
        )
    }

    @DeleteMapping("/{clientId}")
    fun deleteClient(@PathVariable(value = "clientId") clientId: UUID): ResponseEntity<Any> {
        val clientDomainOptional = clientInboundPort.findById(clientId)

        if (clientDomainOptional.isEmpty) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found.")
        }

        clientInboundPort.delete(clientDomainOptional.get())

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Client deleted successfully.")
    }


    @PutMapping("/{clientId}")
    fun updateClient(
        @PathVariable(value = "clientId") clientId: UUID, @RequestBody @Validated clientDto: ClientDTO
    ): ResponseEntity<Any> {

        val clientDomainOptional = clientInboundPort.findById(clientId)

        if (clientDomainOptional.isEmpty) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found.")
        }

        val clientDomain = clientDomainOptional.get()
        clientDomain.name = clientDto.name!!
        clientDomain.cpf = clientDto.cpf!!
        clientDomain.email = clientDto.email!!

        val clientDomainSaved = clientInboundPort.save(clientDomain)
        val clientDTO = clientMapper.toClientResponseDTO(clientDomainSaved)

        return ResponseEntity.status(HttpStatus.OK).body(clientDTO)
    }

    @GetMapping("cpf/{cpf}")
    fun findByCpf(@PathVariable(value = "cpf") clientCpf: String): ResponseEntity<Any> {

        val clientDomainOptional = clientInboundPort.findByCpf(clientCpf)

        return clientDomainOptional.map { clientDomain ->
            val clientDto = clientMapper.toClientDTO(clientDomain)
            ResponseEntity.ok<Any>(clientDto)
        }.orElseGet {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found.")
        }
    }


}
