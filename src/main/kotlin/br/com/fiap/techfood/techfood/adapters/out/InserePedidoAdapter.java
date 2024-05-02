package br.com.fiap.techfood.techfood.adapters.out;

import br.com.fiap.techfood.techfood.adapters.out.repository.PedidoEntityMapper;
import br.com.fiap.techfood.techfood.adapters.out.repository.PedidoRepository;
import br.com.fiap.techfood.techfood.application.core.domain.Cliente;
import br.com.fiap.techfood.techfood.application.core.domain.Pedido;
import br.com.fiap.techfood.techfood.application.ports.out.InserePedidoOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InserePedidoAdapter implements InserePedidoOutputPort {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoEntityMapper pedidoEntityMapper;

    @Override
    public Pedido insert(Pedido pedido, Cliente cliente) {
        var pedidoEntity = pedidoEntityMapper.toEntity(pedido);
        pedidoEntity = pedidoRepository.save(pedidoEntity);
        //TODO ENTITY -> PEDIDO
        return pedido;
    }
}
