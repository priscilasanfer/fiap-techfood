package br.com.fiap.techfood.techfood.application.core.domain.enums;

public enum StatusPedidoEnum {

    AGUARDANDO_PAGAMENTO(1),
    PAGAMENTO_APROVADO(2),
    EM_PREPARO(3),
    FINALIZADO(4),

    ;


    private final Integer code;

    private StatusPedidoEnum(Integer code){
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

}
