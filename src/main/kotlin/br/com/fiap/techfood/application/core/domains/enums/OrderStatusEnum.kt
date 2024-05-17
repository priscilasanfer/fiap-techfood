package br.com.fiap.techfood.application.core.domains.enums

enum class OrderStatusEnum(val code: Int) {
    AWAITING_PAYMENT(1),
    PAYMENT_APPROVED(2),
    REJECTED(3),
    PREPARED(4),
    FINISHED(5),
    ;

    companion object {
        fun toEnum(code: Int?): OrderStatusEnum? {
            if (code == null) {
                return null
            }

            for (x in entries) {
                if (code == x.code) {
                    return x
                }
            }
            throw IllegalArgumentException("Order Status code invalid.")
        }
    }
}
