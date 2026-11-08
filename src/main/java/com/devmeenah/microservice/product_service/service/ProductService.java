package com.devmeenah.microservice.product_service.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.devmeenah.microservice.product_service.dto.ProductRequest;
import com.devmeenah.microservice.product_service.dto.ProductResponse;
import com.devmeenah.microservice.product_service.model.Product;
import com.devmeenah.microservice.product_service.repository.ProductRepository;

import lombok.RequiredArgsConstructor;


@Service 
@RequiredArgsConstructor 
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest) {
        Boolean isProductCreated = false;
        Product aProduct = null;
        try{
            aProduct = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
            productRepository.save(aProduct);

            productRepository.save(aProduct);
            isProductCreated = true;
        }
        catch(Exception e){ 
            isProductCreated = false;
        }

        return isProductCreated && aProduct != null ? new ProductResponse(aProduct.getId(), aProduct.getDescription(), aProduct.getPrice()): null; // Placeholder return value
    }

    public List<Product> getAllProducts() {
        try{
            return productRepository.findAll();
        }
        catch(Exception e){ }

        return null;
    }

}
