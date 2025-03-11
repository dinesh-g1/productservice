package com.dinesh.ms.productservice.advices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dinesh.ms.productservice.exceptions.ProductNotFoundException;
import com.dinesh.ms.productservice.models.exceptions.ProductNotFoundResponse;

@ControllerAdvice
public class ProductNotFoundExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundResponse> handleProductNotFoundException(ProductNotFoundException pnfe) {
        return new ResponseEntity<>(new ProductNotFoundResponse(pnfe.getMessage(), pnfe.getErrorCode()), HttpStatus.NOT_FOUND);
    }
}
