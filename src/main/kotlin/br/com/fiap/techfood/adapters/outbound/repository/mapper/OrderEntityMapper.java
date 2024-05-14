package br.com.fiap.techfood.adapters.outbound.repository.mapper;

import br.com.fiap.techfood.adapters.outbound.repository.entity.OrderEntity;
import br.com.fiap.techfood.application.core.domain.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderEntityMapper {

    public OrderEntity toEntity(Order order) {
        OrderEntity entity = new OrderEntity();

        return entity;
    }

}
