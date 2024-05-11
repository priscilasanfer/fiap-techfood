package br.com.fiap.techfood.application.ports.outbound

interface CpfValidationOutputPort {
    fun isValid(cpf: String?): Boolean
}
