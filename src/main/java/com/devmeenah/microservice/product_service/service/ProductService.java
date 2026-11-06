package com.devmeenah.microservice.product_service.service;

import org.springframework.stereotype.Service;
import com.devmeenah.microservice.product_service.dto.ProductRequest;
import com.devmeenah.microservice.product_service.model.Product;
import com.devmeenah.microservice.product_service.repository.ProductRepository;

import lombok.RequiredArgsConstructor;


@Service 
@RequiredArgsConstructor 
public class ProductService {
    private final ProductRepository productRepository;

    public Boolean createProduct(ProductRequest productRequest) {
        Boolean isProductCreated = false;

        try{
            Product aProduct = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
            productRepository.save(aProduct);

            productRepository.save(aProduct);
            isProductCreated = true;

            return isProductCreated;
        }
        catch(Exception e){ 
            isProductCreated = false;
        }

        return isProductCreated; // Placeholder return value
    }

}
