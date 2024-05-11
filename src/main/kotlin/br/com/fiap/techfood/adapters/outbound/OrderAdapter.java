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
        var orderEntity = orderEntityMapper.toOrderEntity(orderDomain);
        orderEntity = orderRepository.save(orderEntity);
        return orderEntityMapper.toOrderDomain(orderEntity);
    }

    @Override
    public Optional<OrderDomain> findById(UUID id) {
        var optional = orderRepository.findById(id);
        return optional.map(orderEntity -> orderEntityMapper.toOrderDomain(orderEntity));
    }

    @Override
    public List<OrderDomain> findAllByOrderStatus(OrderStatusEnum status) {
        var orderEntityList = orderRepository.findAllByStatus(status.getCode());
        return orderEntityList.stream().map(orderEntity -> orderEntityMapper.toOrderDomain(orderEntity)).toList();
    }

    @Override
    public void delete(UUID id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void updateStatus(UUID id, OrderStatusEnum status) {
        var optOrderEntity = orderRepository.findById(id);
        if(optOrderEntity.isPresent()) {
            var orderEntity = optOrderEntity.get();
            orderEntity.setStatus(status);
            orderRepository.save(orderEntity);
        }
    }

}
