package br.com.fiap.techfood.techfood.application.ports.in;

import br.com.fiap.techfood.techfood.application.core.domain.Cliente;
import br.com.fiap.techfood.techfood.application.core.domain.Pedido;

public interface InserePedidoInputPort {

    public Pedido insert(Pedido pedido, Cliente cliente);

}
