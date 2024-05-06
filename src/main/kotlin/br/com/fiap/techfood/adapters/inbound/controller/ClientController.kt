package br.com.fiap.techfood.adapters.inbound.controller

import br.com.fiap.techfood.adapters.dto.ClientDTO
import br.com.fiap.techfood.adapters.inbound.mapper.ClientMapper
import br.com.fiap.techfood.application.core.domain.ClientDomain
import br.com.fiap.techfood.application.core.domain.PageInfo
import br.com.fiap.techfood.application.ports.inbound.ClientInboundPort
import jakarta.validation.Valid
import org.springframework.beans.BeanUtils
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("/clients")
class ClientController(
    private var clientInboundPort: ClientInboundPort,
    private var clientMapper: ClientMapper

) {
    @PostMapping
    fun save(@RequestBody @Valid clientDTO: ClientDTO): ResponseEntity<Any> {
        try {

            val clientDomain = clientMapper.toClientDomain(clientDTO)
            val clientDomainSaved = clientInboundPort.save(clientDomain)
            val clientDTOSaved = clientMapper.toClientDTO(clientDomainSaved)
            return ResponseEntity.status(HttpStatus.CREATED).body(clientDTOSaved)
        } catch (ex: DataIntegrityViolationException) {
            val errorDetails = mapOf("error" to "Data Integrity Violation", "message" to "CPF or Email already exists.")
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDetails)
        }
    }

    @GetMapping("/{clientId}")
    fun findById(@PathVariable(value = "clientId") clientId: UUID): ResponseEntity<Any> {
        val courseOptionalOptional = clientInboundPort.findById(clientId)

        if (courseOptionalOptional.isEmpty) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found.")
        }
        return ResponseEntity.status(HttpStatus.OK).body(courseOptionalOptional.get())
    }

    @GetMapping
    fun findAllClients(
        @PageableDefault(page = 0, size = 10, direction = Sort.Direction.ASC) pageable: Pageable?
    ): ResponseEntity<Page<ClientDomain>> {
        val pageInfo = PageInfo()
        BeanUtils.copyProperties(pageable!!, pageInfo)

        val clientDomainList = clientInboundPort.findAll(pageInfo)

        return ResponseEntity.status(HttpStatus.OK).body<Page<ClientDomain>>(
            PageImpl<ClientDomain>(
                clientDomainList,
                pageable, clientDomainList.size.toLong()
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


}

