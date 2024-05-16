package br.com.fiap.techfood.adapters.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class OrderItemDto {

    private UUID productId;
    private Integer quantity;
    private String description;

}
