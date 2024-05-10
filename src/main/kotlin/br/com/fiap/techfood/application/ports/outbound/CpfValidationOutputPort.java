package br.com.fiap.techfood.application.ports.outbound;

public interface CpfValidationOutputPort {

    boolean isValid(String cpf);

}
