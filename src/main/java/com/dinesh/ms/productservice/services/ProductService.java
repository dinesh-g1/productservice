package com.dinesh.ms.productservice.services;

import com.dinesh.ms.productservice.entities.Product;
import com.dinesh.ms.productservice.models.ProductRequestDto;

public interface ProductService {

    Long addProduct(ProductRequestDto newProduct);

    Product getProduct(Long productId) throws RuntimeException;
    
}
