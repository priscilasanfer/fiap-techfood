package br.com.fiap.techfood.techfood.adapters.in.controller.mapper;

import br.com.fiap.techfood.techfood.adapters.in.controller.request.CreatePedidoDto;
import br.com.fiap.techfood.techfood.application.core.domain.Pedido;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {

    //TODO
    public Pedido toPedido(CreatePedidoDto createPedidoDto) {
        Pedido pedido = new Pedido();

        return pedido;
    }

}
