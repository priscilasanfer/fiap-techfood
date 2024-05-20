package br.com.fiap.techfood.adapters.dtos

import java.util.*


data class ClientResponseDTO(
    var id: UUID? = null,
    var cpf: String?,
    var name: String?,
    var email: String?
)
