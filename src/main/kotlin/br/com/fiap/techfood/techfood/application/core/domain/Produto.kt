package br.com.fiap.techfood.techfood.application.core.domain

import java.math.BigDecimal

abstract class Produto {

    var nome: String? = null;
    var descricao: String? = null;
    var preco: BigDecimal? = null;

    constructor()

    constructor(nome: String?, descricao: String?, preco: BigDecimal?) {
        this.nome = nome
        this.descricao = descricao
        this.preco = preco
    }

}
