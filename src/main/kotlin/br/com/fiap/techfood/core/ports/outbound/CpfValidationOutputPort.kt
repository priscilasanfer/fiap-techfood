package br.com.fiap.techfood.core.ports.outbound

interface CpfValidationOutputPort {
    fun isValid(cpf: String?): Boolean
}
