package com.product.dto.controller;

import com.product.dto.fakestoreapi.Rating;
import lombok.Data;

@Data
public class ProductRequestDto {
    private String productName;
    private String category;
    private String description;
    private String imageUrl;
    private Double price;
    private Rating rating;
}
