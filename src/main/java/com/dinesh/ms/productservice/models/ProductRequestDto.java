package com.dinesh.ms.productservice.models;

import lombok.Data;

@Data
public class ProductRequestDto {
    private String name;
    private Double price;
    private Integer quantity;
}
