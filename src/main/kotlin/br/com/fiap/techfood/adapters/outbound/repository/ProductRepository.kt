package br.com.fiap.techfood.adapters.outbound.repository

import br.com.fiap.techfood.adapters.outbound.repository.entities.ProductEntity
import br.com.fiap.techfood.application.core.domains.enums.CategoryEnum
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProductRepository : JpaRepository<ProductEntity, UUID?>{
    fun findByCategory(category: CategoryEnum): List<ProductEntity>
}
