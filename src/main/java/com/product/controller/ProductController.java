package com.product.controller;

import com.product.dto.fakestoreapi.ProductResponseDto;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductResponseDto> getProduct(@PathVariable Integer id) {
        ProductResponseDto productResponseDto = this.productService.getProduct(id);
        return new ResponseEntity<>(productResponseDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
        List<ProductResponseDto> productResponseDtoList = this.productService.getAllProducts();
        return new ResponseEntity<>(productResponseDtoList, HttpStatus.OK);
    }
}

