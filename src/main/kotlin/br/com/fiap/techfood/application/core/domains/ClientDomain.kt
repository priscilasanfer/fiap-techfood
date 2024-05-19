package br.com.fiap.techfood.application.core.domains

import java.util.*

data class ClientDomain(
    var id: UUID? = null,
    var cpf: String,
    var name: String,
    var email: String
)