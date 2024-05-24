package br.com.fiap.techfood.adapters.dtos

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.br.CPF


class ClientDTO(
    @field:CPF(message = "Please enter a valid CPF number.")
    @field:NotNull(message = "CPF could not be null")
    var cpf: String?,

    @field:NotNull(message = "Name could not be null")
    @field:NotBlank(message = "Name could not be blank")
    var name: String?,

    @field:Email(message = "Please enter a valid email")
    @field:NotNull(message = "Email could not be null")
    @field:NotBlank(message = "Email could not be blank")
    var email: String?
)
