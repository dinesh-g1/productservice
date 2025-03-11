package com.dinesh.ms.productservice.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotFoundException extends RuntimeException {
    private String errorCode;

    public ProductNotFoundException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
