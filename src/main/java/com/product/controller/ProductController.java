package com.product.controller;

import com.product.dto.controller.ProductResponseDto;
import com.product.mapper.InstanceMapper;
import com.product.models.Product;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(value = "")
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
        List<Product> productList = this.productService.getAllProducts();
        List<ProductResponseDto> productResponseDtoList = new ArrayList<>();
        productList
                .forEach(el -> productResponseDtoList.add(InstanceMapper.mapProductToProductResponseDto(el)));
        return new ResponseEntity<>(productResponseDtoList, HttpStatus.OK);
    }
}

