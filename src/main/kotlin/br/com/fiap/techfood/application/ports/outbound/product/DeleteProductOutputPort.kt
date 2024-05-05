package br.com.fiap.techfood.application.ports.outbound.product

interface DeleteProductOutputPort {
    fun delete(id: Long)
}