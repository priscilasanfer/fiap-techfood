package br.com.fiap.techfood.adapters.inbound.controllers

import br.com.fiap.techfood.adapters.dtos.ProductDTO
import br.com.fiap.techfood.adapters.inbound.mappers.ProductMapper
import br.com.fiap.techfood.application.core.domains.enums.CategoryEnum
import br.com.fiap.techfood.application.ports.inbound.ProductInboundPort
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/products")
class ProductController(
    val productInboundPort: ProductInboundPort,
    val mapper: ProductMapper
){
    @PostMapping
    fun registerNewProduct(@RequestBody @Valid productDTO: ProductDTO?): ResponseEntity<ProductDTO> {
        val product = mapper.dtoToDomain(productDTO)
        val insertProduct = productInboundPort.registerNewProduct(product)
        val responseBody = mapper.domainToDto(insertProduct)
        return ResponseEntity.ok(responseBody)
    }

    @GetMapping("/{id}")
    fun searchProductById(@PathVariable id: UUID): ResponseEntity<ProductDTO> {
        val product = productInboundPort.searchProductById(id)
        val responseBody = mapper.domainToDto(product)
        return ResponseEntity.ok(responseBody)
    }

    @GetMapping("/category")
    fun searchProductByCategory(@RequestParam name: CategoryEnum): ResponseEntity<List<ProductDTO>> {
        val product = productInboundPort.searchProductByCategory(name).map { domain -> mapper.domainToDto(domain) }
        return ResponseEntity.ok(product)
    }

    @GetMapping
    fun findAll(): ResponseEntity<List<ProductDTO>> {
        val product = productInboundPort.findAll().map { domain -> mapper.domainToDto(domain) }
        return ResponseEntity.ok(product)
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: UUID): ResponseEntity<Void> {
        productInboundPort.deleteProduct(id)
        return ResponseEntity.ok().build<Void>()
    }

    @PutMapping("/{id}")
    fun updateProduct(@PathVariable id: UUID, @RequestBody @Valid productDTO: ProductDTO?): ResponseEntity<ProductDTO> {
        val product = mapper.dtoToDomain(productDTO)
        val updatedProduct = productInboundPort.updateProduct(id,product)
        val responseBody = mapper.domainToDto(updatedProduct)
        return ResponseEntity.ok(responseBody)
    }
}
