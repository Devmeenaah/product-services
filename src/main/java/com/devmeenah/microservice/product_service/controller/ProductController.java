package com.devmeenah.microservice.product_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devmeenah.microservice.product_service.dto.ProductRequest;
import com.devmeenah.microservice.product_service.service.ProductService;

import lombok.RequiredArgsConstructor;

import java.util.Objects;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor 
public class ProductController {
    private final ProductService productService;

    @PostMapping("path")
    public Boolean createProduct(@RequestBody ProductRequest productRequest) {
        Boolean isProductCreated = false;

        try{
            if(!Objects.isNull(productRequest) && !Objects.isNull(productRequest.name())){
                isProductCreated = productService.createProduct(productRequest);
            }
        }
        catch(IllegalArgumentException e){
            System.err.println("Error creating product: " + e.getMessage());
        }
        //call create product service class to create product and return true if product is created successfully

        return isProductCreated;
    }
    
}
