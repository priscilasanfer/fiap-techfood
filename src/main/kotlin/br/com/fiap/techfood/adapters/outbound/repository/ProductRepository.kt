package br.com.fiap.techfood.adapters.outbound.repository

import br.com.fiap.techfood.adapters.outbound.repository.entities.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProductRepository : JpaRepository<ProductEntity, UUID?>{
    fun findByCategory(category: Int): List<ProductEntity>
}
