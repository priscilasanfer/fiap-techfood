package br.com.fiap.techfood.adapters.outbound.repository

import br.com.fiap.techfood.adapters.outbound.repository.entities.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<ProductEntity?, Long?>
