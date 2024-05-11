package br.com.fiap.techfood.adapters.outbound.repository;

import br.com.fiap.techfood.adapters.outbound.repository.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {

    List<OrderEntity> findAllByStatus(Integer status);

}
