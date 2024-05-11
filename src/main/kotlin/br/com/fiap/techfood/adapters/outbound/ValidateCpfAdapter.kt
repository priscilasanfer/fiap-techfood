package br.com.fiap.techfood.adapters.outbound

import br.com.fiap.techfood.application.ports.outbound.CpfValidationOutputPort
import org.springframework.stereotype.Component

@Component
class ValidateCpfAdapter : CpfValidationOutputPort {

    override fun isValid(cpf: String?): Boolean {
        return true
    }

}
