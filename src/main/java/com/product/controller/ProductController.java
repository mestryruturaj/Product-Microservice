package com.product.controller;

import com.product.dto.fakestoreapi.FakeStoreApiResponse;
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
    public ResponseEntity<FakeStoreApiResponse> getProduct(@PathVariable Integer id) {
        FakeStoreApiResponse fakeStoreApiResponse = this.productService.getProduct(id);
        return new ResponseEntity<>(fakeStoreApiResponse, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<FakeStoreApiResponse>> getAllProducts() {
        List<FakeStoreApiResponse> fakeStoreApiResponseList = this.productService.getAllProducts();
        return new ResponseEntity<>(fakeStoreApiResponseList, HttpStatus.OK);
    }
}

