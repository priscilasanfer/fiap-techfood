package br.com.fiap.techfood.techfood.adapters.out.repository;

import br.com.fiap.techfood.techfood.adapters.out.repository.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PedidoRepository extends JpaRepository<PedidoEntity, UUID> {
}
