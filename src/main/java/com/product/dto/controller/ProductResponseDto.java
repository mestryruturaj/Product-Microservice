package com.product.dto.controller;

import com.product.models.Product;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ProductResponseDto {
    private HttpStatus status;
    private String message;
    private Product product;
}
