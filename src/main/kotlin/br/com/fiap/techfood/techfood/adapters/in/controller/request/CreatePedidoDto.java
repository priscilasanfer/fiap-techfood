package br.com.fiap.techfood.techfood.adapters.in.controller.request;

import lombok.Data;

import java.util.List;

@Data
public class CreatePedidoDto {

    private String name;
    private List<ItemPedidoDto> itens;
    private String observacoes;
    private ClienteDto cliente;

}
