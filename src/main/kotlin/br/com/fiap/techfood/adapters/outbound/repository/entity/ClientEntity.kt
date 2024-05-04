package br.com.fiap.techfood.adapters.outbound.repository.entity

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "clients")
class ClientEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: UUID,

    @Column(nullable = false, unique = true)
    private var cpf: String,

    @Column(nullable = false)
    private var name: String,

    @Column(nullable = false, unique = true)
    private var email: String
)