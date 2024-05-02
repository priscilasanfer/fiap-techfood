package br.com.fiap.techfood.techfood.application.core.usercase;

import br.com.fiap.techfood.techfood.application.core.domain.Cliente;
import br.com.fiap.techfood.techfood.application.core.domain.Pedido;
import br.com.fiap.techfood.techfood.application.ports.in.InserePedidoInputPort;
import br.com.fiap.techfood.techfood.application.ports.out.InserePedidoOutputPort;

public class CriarPedido implements InserePedidoInputPort {

    InserePedidoOutputPort inserePedidoOutputPort;

    @Override
    public Pedido insert(Pedido pedido, Cliente cliente) {
        return inserePedidoOutputPort.insert(pedido, cliente);
    }

}
