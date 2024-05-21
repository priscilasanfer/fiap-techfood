package br.com.fiap.techfood.adapters.outbound.repository.entities

import jakarta.persistence.*
import org.hibernate.validator.constraints.br.CPF
import java.util.UUID

@Entity
@Table(name = "TB_CLIENTS")
data class ClientEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null,

    @Column(nullable = false, unique = true)
    var cpf: String,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false, unique = true)
    var email: String,

    @OneToMany(mappedBy = "client", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var orders: MutableList<OrderEntity> = mutableListOf()
    )
    {
    constructor(id: UUID) : this(id, "Anonymous", "Anonymous", "Anonymous", mutableListOf())
}
