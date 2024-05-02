package br.com.fiap.techfood.techfood.adapters.in.controller;

import br.com.fiap.techfood.techfood.adapters.in.controller.mapper.PedidoMapper;
import br.com.fiap.techfood.techfood.adapters.in.controller.request.CreatePedidoDto;
import br.com.fiap.techfood.techfood.application.core.domain.Pedido;
import br.com.fiap.techfood.techfood.application.ports.in.InserePedidoInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private InserePedidoInputPort inserePedidoInputPort;

    @Autowired
    private PedidoMapper pedidoMapper;

    //TODO @Valid
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody CreatePedidoDto createPedidoDto) {
        var pedido = pedidoMapper.toPedido(createPedidoDto);

        //TODO
        inserePedidoInputPort.insert(pedido, null);
        return ResponseEntity.ok().build();
    }
}
