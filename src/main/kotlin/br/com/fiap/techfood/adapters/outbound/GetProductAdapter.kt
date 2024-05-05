package br.com.fiap.techfood.adapters.outbound

import br.com.fiap.techfood.adapters.inbound.mapper.ProductMapper
import br.com.fiap.techfood.adapters.outbound.repository.ProductRepository
import br.com.fiap.techfood.adapters.outbound.repository.entity.ProductEntity
import br.com.fiap.techfood.application.core.domain.Product
import br.com.fiap.techfood.application.core.domain.enums.CategoryEnum
import br.com.fiap.techfood.application.ports.outbound.product.GetProductOutputPort
import org.springframework.stereotype.Service

@Service
class GetProductAdapter(
    private val productRepository: ProductRepository,
    private val productMapper: ProductMapper
) : GetProductOutputPort {

    override fun get(id: Long): Product {
        val productEntity = productRepository.findById(id).orElseThrow()

        return productMapper.productEntityToProduct(productEntity)
    }

    override fun getByCategory(category: CategoryEnum): List<Product> {
        val productEntities = productRepository.findByCategory(category)
        return productEntities.map { productEntity ->
            productMapper.productEntityToProduct(productEntity)
        }
    }

    override fun getProducts(): List<Product> {
        val productEntities = productRepository.findAll()
        return productEntities.map { productEntity ->
            productMapper.productEntityToProduct(productEntity)
        }
    }
}

