package br.com.fiap.techfood.application.core.domain

import java.util.*

data class ClientDomain(
    var id: UUID = UUID(0,0),
    var cpf: String = "",
    var name: String = "",
    var email: String = ""
)