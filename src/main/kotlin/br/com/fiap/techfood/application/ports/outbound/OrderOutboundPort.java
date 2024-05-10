package br.com.fiap.techfood.application.ports.outbound;

import br.com.fiap.techfood.application.core.domains.OrderDomain;
import br.com.fiap.techfood.application.core.domains.enums.OrderStatusEnum;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderOutboundPort {

    OrderDomain save(OrderDomain orderDomain);

    Optional<OrderDomain> findById(UUID id);

    List<OrderDomain> findAllByOrderStatus(OrderStatusEnum status);

    void delete(UUID id);

    //CHECAR QUAIS PARAMS ID?
    void approvePayment(UUID id);

}
