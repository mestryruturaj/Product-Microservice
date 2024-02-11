package com.product.service;

import com.product.dto.fakestoreapi.FakeStoreApiResponse;
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
    public FakeStoreApiResponse getProduct(Integer id);

    /**
     * Method is used to fetch all the products available on fakestoreapi
     *
     * @return List of FakeStoreApiProductResponseDto
     */
    public List<FakeStoreApiResponse> getAllProducts();
}
