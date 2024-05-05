package br.com.fiap.techfood.adapters.inbound.controller

import br.com.fiap.techfood.adapters.dto.ProductDTO
import br.com.fiap.techfood.adapters.inbound.mapper.ProductMapper
import br.com.fiap.techfood.application.core.domain.Product
import br.com.fiap.techfood.application.core.domain.enums.CategoryEnum
import br.com.fiap.techfood.application.ports.inbound.product.DeleteProductInputPort
import br.com.fiap.techfood.application.ports.inbound.product.GetProductInputPort
import br.com.fiap.techfood.application.ports.inbound.product.InsertProductInputPort
import br.com.fiap.techfood.application.ports.inbound.product.UpdateProductInputPort
import br.com.fiap.techfood.application.ports.outbound.product.GetProductOutputPort
import br.com.fiap.techfood.application.ports.outbound.product.InsertProductOutputPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/products")
class ProductController(
    @Autowired private val insertProductInputPort: InsertProductInputPort,
    @Autowired private val getProductInputPort: GetProductInputPort,
    @Autowired private val deleteProductInputPort: DeleteProductInputPort,
    @Autowired private val updateProductInputPort: UpdateProductInputPort,
    @Autowired private val productMapper: ProductMapper,
){
    @PostMapping("/insert")
    fun insert(@RequestBody productDTO: ProductDTO?): ResponseEntity<Product> {
        val product = productMapper.toProduct(productDTO)
        val insertProduct = insertProductInputPort.insert(product)
        return ResponseEntity.ok(insertProduct)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Product> {
        val product = getProductInputPort.get(id)
        return ResponseEntity.ok(product)
    }

    @GetMapping("/category")
    fun getByCategory(@RequestParam name: CategoryEnum): ResponseEntity<List<Product>> {
        val product = getProductInputPort.getByCategory(name)
        return ResponseEntity.ok(product)
    }

    @GetMapping
    fun getProducts(): ResponseEntity<List<Product>> {
        val product = getProductInputPort.getProducts()
        return ResponseEntity.ok(product)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long): ResponseEntity<Void> {
        deleteProductInputPort.delete(id)
        return ResponseEntity.ok().build<Void>()
    }

    @PutMapping("/update/{id}")
    fun update(@PathVariable id: Long, @RequestBody productDTO: ProductDTO?): ResponseEntity<Product> {
        val product = productMapper.toProduct(productDTO)
        updateProductInputPort.update(id,product)
        return ResponseEntity.ok(product)
    }
}
