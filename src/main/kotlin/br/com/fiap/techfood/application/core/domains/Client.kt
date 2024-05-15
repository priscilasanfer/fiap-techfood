package br.com.fiap.techfood.application.core.domains

import java.util.*

data class Client(
    var id: UUID = UUID(0,0),
    var cpf: String = "",
    var name: String = "",
    var email: String = ""
)