package br.com.fiap.techfood.adapters.inbound.mappers;

import br.com.fiap.techfood.adapters.dtos.CartDTO;
import br.com.fiap.techfood.adapters.dtos.OrderItemDto;
import br.com.fiap.techfood.application.core.domains.CartDomain;
import br.com.fiap.techfood.application.core.domains.OrderItemDomain;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.beans.Beans;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartMapper {

    public CartDomain toCartDomain(CartDTO cartDTO) {
        var cartDomain = new CartDomain();
        cartDomain.setCartProducts(toOrderItemDomainList(cartDTO.getCartProducts()));
        return cartDomain;
    }

    public List<OrderItemDomain> toOrderItemDomainList(List<OrderItemDto> items)  {
        if(items == null) {
            return null;
        }
        return items.stream().map(this::toOrderItemDomain).collect(Collectors.toList());
    }

    public OrderItemDomain toOrderItemDomain(OrderItemDto orderItemDto) {
        var orderItemDomain =  new OrderItemDomain();
        BeanUtils.copyProperties(orderItemDto, orderItemDomain);
        return  orderItemDomain;
    }
}
