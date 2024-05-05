package br.com.fiap.techfood.adapters.dto

import jakarta.validation.constraints.Email
import org.hibernate.validator.constraints.br.CPF
import org.jetbrains.annotations.NotNull

data class ClientDTO(
    @NotNull
    @CPF
    var cpf: String,

    @NotNull
    var name: String,

    @NotNull
    @Email
    var email: String
)