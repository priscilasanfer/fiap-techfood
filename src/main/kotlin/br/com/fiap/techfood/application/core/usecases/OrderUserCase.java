package br.com.fiap.techfood.application.core.usecases;

import br.com.fiap.techfood.application.core.domains.CartDomain;
import br.com.fiap.techfood.application.core.domains.ClientDomain;
import br.com.fiap.techfood.application.core.domains.OrderDomain;
import br.com.fiap.techfood.application.core.domains.enums.OrderStatusEnum;
import br.com.fiap.techfood.application.ports.inbound.OrderInboundPort;
import br.com.fiap.techfood.application.ports.outbound.CpfValidationOutputPort;
import br.com.fiap.techfood.application.ports.outbound.OrderOutboundPort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OrderUserCase implements OrderInboundPort {

    private CpfValidationOutputPort cpfValidationOutputPort;
    private OrderOutboundPort orderOutboundPort;

    @Override
    public OrderDomain save(CartDomain cartDomain, ClientDomain clientDomain) {
        OrderDomain orderDomain = new OrderDomain();

        if(!clientDomain.getCpf().isBlank()) {
            var isValidCpf = cpfValidationOutputPort.isValid(clientDomain.getCpf());
            if(!isValidCpf) {
                throw new RuntimeException("CPF não valido");
            }

            //checar se cliente existe?

            orderDomain.setClient(clientDomain);
        }

        orderDomain.setStatus(OrderStatusEnum.AWAITING_PAYMENT.getCode());
        orderDomain.setItems(cartDomain.getCartProducts());
        orderDomain = orderOutboundPort.save(orderDomain);
        return orderDomain;
    }

    @Override
    public Optional<OrderDomain> findById(UUID id) {
        return orderOutboundPort.findById(id);
    }

    //PARA TELA DA COZINHA
    @Override
    public List<OrderDomain> findAllApprovedOrders() {
        return orderOutboundPort.findAllByOrderStatus(OrderStatusEnum.PAYMENT_APPROVED);
    }

    //PARA TELA DE CLIENTES
    @Override
    public List<OrderDomain> findAllPrepared() {
        return orderOutboundPort.findAllByOrderStatus(OrderStatusEnum.PREPARED);
    }

    @Override
    public void delete(UUID id) {
        //CHECK IF EXISTS
        //STATUS != APPROVED OR FINISH
        //STATUS == AWAITING PAYMENT
        //expired
        orderOutboundPort.delete(id);
    }

    //TODO CHECKOUT MOCK
    private void approvePayment() {
        //check if exists
        //check status
        //aprove
    }

}
