package com.product.service;

import com.product.dto.fakestoreapi.ProductResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static utils.ArrayUtils.convertArrayToList;

@Service(value = "productService")
public class ProductServiceImpl implements ProductService {
    private RestTemplate restTemplate;

    @Autowired
    public ProductServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Method is used to fetch the Model from fakestoreapi.com having product.id = id
     *
     * @param id : Integer
     * @return FakeStoreApiProductResponseDto
     */
    @Override
    public ProductResponseDto getProduct(Integer id) {
        String url = "https://fakestoreapi.com/products/{productId}";
        ResponseEntity<ProductResponseDto> productResponseDtoResponseEntity =
                restTemplate.getForEntity(url, ProductResponseDto.class, id);
        return productResponseDtoResponseEntity.getBody();
    }

    /**
     * Method is used to fetch all the products available on fakestoreapi
     *
     * @return List of FakeStoreApiProductResponseDto
     */
    @Override
    public List<ProductResponseDto> getAllProducts() {
        String url = "https://fakestoreapi.com/products";
        ResponseEntity<ProductResponseDto[]> productResponseDtoArrayResponseEntity =
                this.restTemplate.getForEntity(url, ProductResponseDto[].class);
        return convertArrayToList(productResponseDtoArrayResponseEntity.getBody());
    }


}
