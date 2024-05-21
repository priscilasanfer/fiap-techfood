package br.com.fiap.techfood.adapters.inbound.exceptions

import br.com.fiap.techfood.core.application.domains.exceptions.DataIntegrityException
import br.com.fiap.techfood.core.application.domains.exceptions.ObjectNotFoundException
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException::class)
    fun objectNotFound(e: ObjectNotFoundException, request: HttpServletRequest): ResponseEntity<StandardError> {
        val err = StandardError(HttpStatus.NOT_FOUND.value(), e.message!!, System.currentTimeMillis())
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err)
    }

    @ExceptionHandler(DataIntegrityException::class)
    fun dataIntegrity(e: DataIntegrityException, request: HttpServletRequest): ResponseEntity<StandardError> {
        val err = StandardError(HttpStatus.BAD_REQUEST.value(), e.message!!, System.currentTimeMillis())
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err)
    }
}
