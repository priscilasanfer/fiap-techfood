package br.com.fiap.techfood.adapters.outbound.repository.entity

import br.com.fiap.techfood.adapters.dto.ClientDTO
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class ClientEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: Long = 0,
    private val cpf: String,
    private val name: String,
    private var email: String
) {
    constructor(cpf: String, name: String, email: String) : this(0, cpf, name, email)
    fun toClient() = ClientDTO(this.cpf, this.name, this.email)
}