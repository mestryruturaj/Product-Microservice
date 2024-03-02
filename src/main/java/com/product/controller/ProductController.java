package com.product.controller;

import com.product.dto.controllerapi.ProductRequestDto;
import com.product.dto.controllerapi.ProductResponseDto;
import com.product.exception.ProductServiceException;
import com.product.mapper.InstanceMapper;
import com.product.models.Product;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Method provides an interface to handle the endpoint
     *
     * @param id : Integer
     * @return ResponseEntity of ProductResponseDto
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductResponseDto> getProduct(@PathVariable Integer id) {
        Product product = this.productService.getProduct(id);
        if (ObjectUtils.isEmpty(product)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            ProductResponseDto productResponseDto = InstanceMapper.mapProductToProductResponseDto(product);
            productResponseDto.setStatus(HttpStatus.OK);
            productResponseDto.setMessage(String.format("Product with id = %d was successfully fetched.", id));
            return new ResponseEntity<>(productResponseDto, HttpStatus.OK);
        }

    }

    /**
     * Method provides an interface to handle the endpoint
     *
     * @return ResponseEntity of List of ProductResponseDto
     */
    @GetMapping(value = "")
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
        List<Product> productList = this.productService.getAllProducts();
        List<ProductResponseDto> productResponseDtoList = new ArrayList<>();
        productList
                .forEach(el -> {
                    ProductResponseDto productResponseDto = InstanceMapper.mapProductToProductResponseDto(el);
                    productResponseDto.setStatus(HttpStatus.OK);
                    productResponseDto.setMessage(String.format("Product was successfully fetched."));
                    productResponseDtoList.add(productResponseDto);
                });
        return new ResponseEntity<>(productResponseDtoList, HttpStatus.OK);
    }

    /**
     * Method provides an interface to create an product
     *
     * @param productRequestDto : ProductRequestDto
     * @return ProductResponseDto
     * @throws ProductServiceException occurs when new product couldnt be inserted
     */
    @PostMapping(value = "")
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductRequestDto productRequestDto) {
        Product product = InstanceMapper.mapProductRequestDtoToProduct(productRequestDto);
        Product newProduct = productService.createProduct(product);
        if (ObjectUtils.isEmpty(newProduct)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            ProductResponseDto productResponseDto = InstanceMapper.mapProductToProductResponseDto(newProduct);
            productResponseDto.setStatus(HttpStatus.CREATED);
            productResponseDto.setMessage("Product with id " + product.getId() + " was successfully created.");
            return new ResponseEntity<>(productResponseDto, HttpStatus.CREATED);
        }
    }

    /**
     * Method provides an interface to update or modify existing product
     *
     * @param id Integer
     * @return ProductResponseDto
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductResponseDto> putProduct(@PathVariable Integer id, @RequestBody ProductRequestDto productRequestDto) {
        Product product = InstanceMapper.mapProductRequestDtoToProduct(productRequestDto);
        Product responseProduct = productService.putProduct(id, product);
        if (ObjectUtils.isEmpty(responseProduct)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            ProductResponseDto productResponseDto = InstanceMapper.mapProductToProductResponseDto(responseProduct);
            return new ResponseEntity<>(productResponseDto, HttpStatus.OK);
        }
    }
}

/*
 * Features
 * 1. fetch all
 * 2. fetch one
 * 3. create one
 * 4. edit one
 * 5. delete one
 * */

