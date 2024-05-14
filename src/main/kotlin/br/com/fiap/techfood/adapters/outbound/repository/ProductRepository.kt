package br.com.fiap.techfood.adapters.outbound.repository

import br.com.fiap.techfood.adapters.outbound.repository.entities.ProductEntity
import br.com.fiap.techfood.application.core.domain.enums.CategoryEnum
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<ProductEntity?, Long?>{
    fun findByCategory(category: CategoryEnum): List<ProductEntity>
}
