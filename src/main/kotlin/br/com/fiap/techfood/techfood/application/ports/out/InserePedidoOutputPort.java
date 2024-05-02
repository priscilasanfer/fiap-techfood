package br.com.fiap.techfood.techfood.application.ports.out;

import br.com.fiap.techfood.techfood.application.core.domain.Cliente;
import br.com.fiap.techfood.techfood.application.core.domain.Pedido;

public interface InserePedidoOutputPort {

    Pedido insert(Pedido pedido, Cliente cliente);

}
