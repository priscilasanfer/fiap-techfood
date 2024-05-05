package br.com.fiap.techfood.application.ports.inbound.product

interface DeleteProductInputPort {
    fun delete(id: Long)
}