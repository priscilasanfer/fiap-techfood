package br.com.fiap.techfood.adapters.outbound.repository

import br.com.fiap.techfood.adapters.outbound.repository.entity.ClientEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ClientRepository : JpaRepository<ClientEntity?, Long?>
