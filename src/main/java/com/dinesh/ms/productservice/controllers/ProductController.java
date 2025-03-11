package com.dinesh.ms.productservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dinesh.ms.productservice.entities.Product;
import com.dinesh.ms.productservice.models.ProductRequestDto;
import com.dinesh.ms.productservice.models.ProductResponse;
import com.dinesh.ms.productservice.services.ProductService;



@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("")
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequestDto newProduct) {
        Long productId = productService.addProduct(newProduct);

        return new ResponseEntity<Long>(productId, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProducEntity(@PathVariable("id") Long productId) {
        
        Product product = productService.getProduct(productId);

        ProductResponse productResponse = ProductResponse.builder()
                                            .id(product.getId())
                                            .name(product.getName())
                                            .price(product.getPrice())
                                            .quantity(product.getQuantity())
                                            .build();
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
        
    }
    
}
