package com.product.models;

import com.product.dto.fakestoreapi.Rating;
import lombok.Data;

@Data
public class Product {
    private String productName;
    private String description;
    private String imageUrl;
    private String category;
    private Double price;
    private Rating rating;
}
