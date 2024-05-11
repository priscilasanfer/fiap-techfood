package br.com.fiap.techfood.adapters.outbound.repository.entities

import jakarta.persistence.*
import org.hibernate.validator.constraints.br.CPF
import java.util.UUID

@Entity
@Table(name = "clients")
class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null;

    @Column(nullable = false, unique = true)
    var cpf: String? = null

    @Column(nullable = false)
    var name: String? = null

    @Column(nullable = false, unique = true)
    var email: String? = null

    @OneToMany(mappedBy = "client")
    var orders: MutableList<OrderEntity> = mutableListOf()

    constructor(id: UUID) {
        this.id = id;
    }

    constructor(id: UUID, cpf: String, name: String, email: String) {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        this.email = email;
    }

}
