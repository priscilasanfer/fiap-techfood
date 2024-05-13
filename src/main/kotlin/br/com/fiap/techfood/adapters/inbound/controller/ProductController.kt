package br.com.fiap.techfood.adapters.inbound.controller

import br.com.fiap.techfood.adapters.dto.ProductDTO
import br.com.fiap.techfood.adapters.inbound.mapper.ProductMapper
import br.com.fiap.techfood.application.core.domain.Product
import br.com.fiap.techfood.application.core.domain.enums.CategoryEnum
import br.com.fiap.techfood.application.ports.inbound.product.DeleteProductInputPort
import br.com.fiap.techfood.application.ports.inbound.product.GetProductInputPort
import br.com.fiap.techfood.application.ports.inbound.product.InsertProductInputPort
import br.com.fiap.techfood.application.ports.inbound.product.UpdateProductInputPort
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/products")
class ProductController(
    val insertProductInputPort: InsertProductInputPort,
    val getProductInputPort: GetProductInputPort,
    val deleteProductInputPort: DeleteProductInputPort,
    val updateProductInputPort: UpdateProductInputPort,
    val productMapper: ProductMapper,
){
    @PostMapping
    fun save(@RequestBody @Valid productDTO: ProductDTO?): ResponseEntity<Product> {
        val product = productMapper.toProduct(productDTO)
        val insertProduct = insertProductInputPort.insert(product)
        return ResponseEntity.ok(insertProduct)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Product> {
        val product = getProductInputPort.get(id)
        return ResponseEntity.ok(product)
    }

    @GetMapping("/category")
    fun findByCategory(@RequestParam name: CategoryEnum): ResponseEntity<List<Product>> {
        val product = getProductInputPort.getByCategory(name)
        return ResponseEntity.ok(product)
    }

    @GetMapping
    fun findAll(): ResponseEntity<List<Product>> {
        val product = getProductInputPort.getProducts()
        return ResponseEntity.ok(product)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long): ResponseEntity<Void> {
        deleteProductInputPort.delete(id)
        return ResponseEntity.ok().build<Void>()
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody @Valid productDTO: ProductDTO?): ResponseEntity<Product> {
        val product = productMapper.toProduct(productDTO)
        updateProductInputPort.update(id,product)
        return ResponseEntity.ok(product)
    }
}
