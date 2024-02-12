package com.product.mapper;

import com.product.dto.controller.ProductRequestDto;
import com.product.dto.controller.ProductResponseDto;
import com.product.dto.fakestoreapi.FakeStoreApiRequest;
import com.product.dto.fakestoreapi.FakeStoreApiResponse;
import com.product.models.Product;

public class InstanceMapper {
    /**
     * Method provides an interface for mapping productRequestDto to Product
     *
     * @param productRequestDto : ProductResponseDti
     * @return
     */
    public static Product mapProductRequestDtoToProduct(ProductRequestDto productRequestDto) {
        Product product = new Product();
        product.setProductName(productRequestDto.getProductName());
        product.setCategory(productRequestDto.getCategory());
        product.setDescription(productRequestDto.getDescription());
        product.setPrice(productRequestDto.getPrice());
        product.setImageUrl(productRequestDto.getImageUrl());
        product.setRating(productRequestDto.getRating());
        return product;
    }

    /**
     * Method provides an interface for mapping product to FakeStoreApiRequest
     *
     * @param product
     * @return
     */
    public static FakeStoreApiRequest mapProductToFakeStoreApiRequst(Product product) {
        FakeStoreApiRequest fakeStoreApiRequest = new FakeStoreApiRequest();
        fakeStoreApiRequest.setTitle(product.getProductName());
        fakeStoreApiRequest.setCategory(product.getCategory());
        fakeStoreApiRequest.setDescription(product.getDescription());
        fakeStoreApiRequest.setImage(product.getImageUrl());
        fakeStoreApiRequest.setPrice(product.getPrice());
        return fakeStoreApiRequest;
    }

    /**
     * Method provides an interface for mapping fakeStoreApiResponse to Product
     *
     * @param fakeStoreApiResponse : FakeStoreApiResponse
     * @return Product
     */
    public static Product mapFakeStoreApiResponseToProduct(FakeStoreApiResponse fakeStoreApiResponse) {
        Product product = new Product();
        product.setProductName(fakeStoreApiResponse.getTitle());
        product.setCategory(fakeStoreApiResponse.getCategory());
        product.setDescription(fakeStoreApiResponse.getDescription());
        product.setPrice(fakeStoreApiResponse.getPrice());
        product.setImageUrl(fakeStoreApiResponse.getImage());
        product.setRating(fakeStoreApiResponse.getRating());
        return product;
    }

    /**
     * Method provides an interface for mapping Product to ProductResponseDto
     *
     * @param product : Product
     * @return ProductResponseDto
     */
    public static ProductResponseDto mapProductToProductResponseDto(Product product) {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setProduct(product);
        return productResponseDto;
    }

}
