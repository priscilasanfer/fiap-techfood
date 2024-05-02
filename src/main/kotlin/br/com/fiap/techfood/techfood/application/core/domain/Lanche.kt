package br.com.fiap.techfood.techfood.application.core.domain

import java.math.BigDecimal

class Lanche : Produto {

    var obeservacao: String? = null;

    constructor() : super()

    constructor(nome: String?, descricao: String?, preco: BigDecimal?, obeservacao: String?) : super(
        nome,
        descricao,
        preco
    ) {
        this.obeservacao = obeservacao
    }

}