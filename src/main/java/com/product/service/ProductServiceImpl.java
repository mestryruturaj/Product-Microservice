package com.product.service;

import com.product.dto.fakestoreapi.FakeStoreApiResponse;
import com.product.external.clients.FakeStoreApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.product.utils.ArrayUtils.convertArrayToList;

@Service(value = "productService")
public class ProductServiceImpl implements ProductService {
    private FakeStoreApiClient fakeStoreApiClient;

    @Autowired
    public ProductServiceImpl(FakeStoreApiClient fakeStoreApiClient) {
        this.fakeStoreApiClient = fakeStoreApiClient;
    }

    /**
     * Method is used to fetch the Model from fakestoreapi.com having product.id = id
     *
     * @param id : Integer
     * @return FakeStoreApiProductResponseDto
     */
    @Override
    public FakeStoreApiResponse getProduct(Integer id) {
        return null;
    }

    /**
     * Method is used to fetch all the products available on fakestoreapi
     *
     * @return List of FakeStoreApiProductResponseDto
     */
    @Override
    public List<FakeStoreApiResponse> getAllProducts() {
        List<FakeStoreApiResponse> fakeStoreApiResponseList = this.fakeStoreApiClient.getAllProducts();



        return null;
    }

    /*
    * TODO:
    *  change method implementatio using client class
    * */
}
