package com.product.dto.controllerapi;

import com.product.models.Product;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ProductResponseDto {
    private HttpStatus status;
    private String message;
    private Product product;
}
