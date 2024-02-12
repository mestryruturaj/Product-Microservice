package com.product.service;

import com.product.dto.fakestoreapi.FakeStoreApiResponse;
import com.product.exception.ProductServiceException;
import com.product.external.clients.FakeStoreApiClient;
import com.product.mapper.InstanceMapper;
import com.product.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "productService")
public class ProductServiceImpl implements ProductService {
    private FakeStoreApiClient fakeStoreApiClient;

    @Autowired
    public ProductServiceImpl(FakeStoreApiClient fakeStoreApiClient) {
        this.fakeStoreApiClient = fakeStoreApiClient;
    }

    /**
     * Method provides an interface to get a product from fakestoreapi.com using id
     *
     * @param id : Integer
     * @return Product
     */
    @Override
    public Product getProduct(Integer id) {
        try {
            FakeStoreApiResponse fakeStoreApiResponse = this.fakeStoreApiClient.getProduct(id);
            Product product = InstanceMapper.mapFakeStoreApiResponseToProduct(fakeStoreApiResponse);
            return product;
        } catch (ProductServiceException exception) {
            return null;
        }
    }

    /**
     * Method provides an interface to get a list of products from fakestoreapi.com
     *
     * @return List of products
     */
    @Override
    public List<Product> getAllProducts() {
        List<FakeStoreApiResponse> fakeStoreApiResponseList = this.fakeStoreApiClient.getAllProducts();
        List<Product> productList = new ArrayList<>();
        fakeStoreApiResponseList.stream()
                .forEach(el -> productList.add(InstanceMapper.mapFakeStoreApiResponseToProduct(el)));
        return productList;
    }
}
