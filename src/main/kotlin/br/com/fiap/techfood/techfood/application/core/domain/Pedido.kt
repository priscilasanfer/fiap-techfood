package br.com.fiap.techfood.techfood.application.core.domain

import br.com.fiap.techfood.techfood.application.core.domain.enums.StatusPedidoEnum
import java.util.UUID

//TODO
class Pedido {

    var id: UUID? = null;
    var nome: String? = null;
    var itens: List<ItemPedido>? = null;
    private var status: Int? = null;

    constructor(){
        this.status = StatusPedidoEnum.AGUARDANDO_PAGAMENTO.code;
    }

    constructor(nome: String?, itens: List<ItemPedido>) {
        this.nome = nome
        this.itens = itens;
    }


}