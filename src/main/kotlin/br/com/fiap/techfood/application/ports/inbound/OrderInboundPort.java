package br.com.fiap.techfood.application.ports.inbound;

import br.com.fiap.techfood.application.core.domains.CartDomain;
import br.com.fiap.techfood.application.core.domains.ClientDomain;
import br.com.fiap.techfood.application.core.domains.OrderDomain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderInboundPort {

    OrderDomain save(CartDomain cartDomain, ClientDomain client);

    Optional<OrderDomain> findById(UUID id);

    List<OrderDomain> findAllApprovedOrders();

    List<OrderDomain> findAllPrepared();

    void delete(UUID id);

}
