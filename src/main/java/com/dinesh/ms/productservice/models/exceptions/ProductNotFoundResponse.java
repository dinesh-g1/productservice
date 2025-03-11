package com.dinesh.ms.productservice.models.exceptions;

import lombok.Getter;

@Getter
public class ProductNotFoundResponse {
    private String message;
    private String errorCode;
    public ProductNotFoundResponse(String message, String errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
