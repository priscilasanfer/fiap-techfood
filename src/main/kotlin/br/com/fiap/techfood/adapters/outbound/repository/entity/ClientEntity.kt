package br.com.fiap.techfood.adapters.outbound.repository.entity

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "clients")
class ClientEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID,

    @Column(nullable = false, unique = true)
    var cpf: String,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false, unique = true)
    var email: String
)