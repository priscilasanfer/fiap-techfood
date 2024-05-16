package br.com.fiap.techfood.adapters.inbound.controllers

import br.com.fiap.techfood.adapters.dtos.ProductDTO
import br.com.fiap.techfood.adapters.inbound.mappers.ProductMapper
import br.com.fiap.techfood.application.core.domains.Product
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
    val productMapper: ProductMapper
){
    @PostMapping
    fun save(@RequestBody @Valid productDTO: ProductDTO?): ResponseEntity<ProductDTO> {
        val product = productMapper.toProduct(productDTO)
        val insertProduct = productInboundPort.save(product)
        val responseBody = productMapper.productToProductDto(insertProduct)
        return ResponseEntity.ok(responseBody)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: UUID): ResponseEntity<ProductDTO> {
        val product = productInboundPort.findById(id)
        val responseBody = productMapper.productToProductDto(product)
        return ResponseEntity.ok(responseBody)
    }

    @GetMapping("/category")
    fun findByCategory(@RequestParam name: CategoryEnum): ResponseEntity<List<ProductDTO>> {
        val product = productInboundPort.findByCategory(name).map { domain -> productMapper.productToProductDto(domain) }
        return ResponseEntity.ok(product)
    }

    @GetMapping
    fun findAll(): ResponseEntity<List<ProductDTO>> {
        val product = productInboundPort.findAll().map { domain -> productMapper.productToProductDto(domain) }
        return ResponseEntity.ok(product)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: UUID): ResponseEntity<Void> {
        productInboundPort.delete(id)
        return ResponseEntity.ok().build<Void>()
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: UUID, @RequestBody @Valid productDTO: ProductDTO?): ResponseEntity<ProductDTO> {
        val product = productMapper.toProduct(productDTO)
        val updatedProduct = productInboundPort.update(id,product)
        val responseBody = productMapper.productToProductDto(updatedProduct)
        return ResponseEntity.ok(responseBody)
    }
}
