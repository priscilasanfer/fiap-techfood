package br.com.fiap.techfood.adapters.outbound;

import br.com.fiap.techfood.adapters.outbound.repository.OrderRepository;
import br.com.fiap.techfood.adapters.outbound.repository.mappers.OrderEntityMapper;
import br.com.fiap.techfood.application.core.domains.OrderDomain;
import br.com.fiap.techfood.application.core.domains.enums.OrderStatusEnum;
import br.com.fiap.techfood.application.ports.outbound.OrderOutboundPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class OrderAdapter implements OrderOutboundPort {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderEntityMapper orderEntityMapper;

    @Override
    public OrderDomain save(OrderDomain orderDomain) {
        var orderEntity = orderEntityMapper.toEntity(orderDomain);
        orderEntity = orderRepository.save(orderEntity);
        return orderEntityMapper.toDomain(orderEntity);
    }

    @Override
    public Optional<OrderDomain> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<OrderDomain> findAllByOrderStatus(OrderStatusEnum status) {
        return List.of();
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public void approvePayment(UUID id) {

    }
}
