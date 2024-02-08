package com.product.service;

import com.product.dto.fakestoreapi.ProductResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    /**
     * Method is used to fetch the Model from fakestoreapi.com having product.id = id
     *
     * @param id : Integer
     * @return FakeStoreApiProductResponseDto
     */
    public ProductResponseDto getProduct(Integer id);

    /**
     * Method is used to fetch all the products available on fakestoreapi
     *
     * @return List of FakeStoreApiProductResponseDto
     */
    public List<ProductResponseDto> getAllProducts();
}
