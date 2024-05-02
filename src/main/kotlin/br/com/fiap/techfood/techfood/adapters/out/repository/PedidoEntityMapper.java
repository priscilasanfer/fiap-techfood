package br.com.fiap.techfood.techfood.adapters.out.repository;

import br.com.fiap.techfood.techfood.adapters.out.repository.entity.PedidoEntity;
import br.com.fiap.techfood.techfood.application.core.domain.Pedido;
import org.springframework.stereotype.Component;

@Component
public class PedidoEntityMapper {

    //TODO
    public PedidoEntity toEntity(Pedido pedido) {
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setNome(pedido.getNome());
        //bens utils copy properties (tem subclasses para converter também)

        return pedidoEntity;
    }

}
