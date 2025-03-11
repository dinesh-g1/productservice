package com.dinesh.ms.productservice.services.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dinesh.ms.productservice.entities.Product;
import com.dinesh.ms.productservice.models.ProductRequestDto;
import com.dinesh.ms.productservice.repositories.ProductRepository;
import com.dinesh.ms.productservice.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Long addProduct(ProductRequestDto newProduct) {
        Product product = Product.builder()
                            .name(newProduct.getName())
                            .price(newProduct.getPrice())
                            .quantity(newProduct.getQuantity())
                            .build();
        product = productRepository.save(product);

        return product.getId();
    }

    @Override
    public Product getProduct(Long productId) throws RuntimeException {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            return product.get();
        } else {
            throw new RuntimeException("Product Not Found");
        }
    }
    
}
