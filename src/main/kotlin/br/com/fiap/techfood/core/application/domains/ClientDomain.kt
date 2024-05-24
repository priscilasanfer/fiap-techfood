package br.com.fiap.techfood.core.application.domains

import java.util.*

class ClientDomain(
    var id: UUID? = null,
    var cpf: String,
    var name: String,
    var email: String
)