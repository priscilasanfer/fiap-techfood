package br.com.fiap.techfood.application.core.domains.enums;

public enum OrderStatusEnum {

    AWAITING_PAYMENT(1),
    PAYMENT_APPROVED(2),
    REJECTED(3),
    PREPARED(4),
    FINISHED(5),

    ;
    private final Integer code;

    private OrderStatusEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public static OrderStatusEnum toEnum(Integer code) {
        if (code == null) {
            return null;
        }

        for (OrderStatusEnum x : OrderStatusEnum.values()) {
            if (code.equals(x.getCode())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Order Status code invalid.");
    }

}
