package br.com.fiap.techfood.adapters.outbound.repository;

import br.com.fiap.techfood.adapters.outbound.repository.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {
}
