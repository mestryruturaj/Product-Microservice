package com.product.dto.fakestoreapi;

import lombok.Data;

@Data
public class FakeStoreApiRequest {
    private String title;
    private Double price;
    private String description;
    private String image;
    private String category;
}
