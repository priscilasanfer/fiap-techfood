package br.com.fiap.techfood.application.core.domains

import java.util.*

data class ClientDomain(
    var id: UUID? = null,
    var cpf: String? = null,
    var name: String? = null,
    var email: String? = null
)