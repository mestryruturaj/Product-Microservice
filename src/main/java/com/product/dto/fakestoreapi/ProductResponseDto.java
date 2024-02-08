package com.product.dto.fakestoreapi;

import lombok.Data;

@Data
public class ProductResponseDto {
    private Long id;
    private String title;
    private Double price;
    private String description;
    private String category;
    private String image;
    private Rating rating;
}
