package br.com.fiap.techfood.core.application.domains

import br.com.fiap.techfood.core.application.domains.enums.OrderStatusEnum
import java.util.UUID


class OrderDomain {

    var id: UUID? = null;
    var name: String? = null;
    var items: List<OrderItemDomain>? = null;
    var status: OrderStatusEnum = OrderStatusEnum.AWAITING_PAYMENT;
    var isAnonymous: Boolean? = true;
    var client: ClientDomain? = null;
}
