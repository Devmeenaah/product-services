package com.devmeenah.microservice.product_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devmeenah.microservice.product_service.dto.ProductRequest;
import com.devmeenah.microservice.product_service.dto.ProductResponse;
import com.devmeenah.microservice.product_service.service.ProductService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor 
public class ProductController {
    private final ProductService productService;

    @PostMapping("create-product")
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
        Boolean isProductCreated = false;

        try{
            if(!Objects.isNull(productRequest) && !Objects.isNull(productRequest.name())){
                return  productService.createProduct(productRequest);
            }
        }
        catch(IllegalArgumentException e){
            System.err.println("Error creating product: " + e.getMessage());
        }
 
        return null;
    }

    @GetMapping("get-all-products")
    public List<ProductRequest> getAllProducts() {
        return productService.getAllProducts()
            .stream()
            .map(product -> new ProductRequest(
                product.getName(),
                product.getDescription(),
                product.getPrice()
            ))
            .collect(Collectors.toList());
    }
    
    
}
