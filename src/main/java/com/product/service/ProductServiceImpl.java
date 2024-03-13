package com.product.service;

import com.product.dto.fakestoreapi.FakeStoreApiRequest;
import com.product.dto.fakestoreapi.FakeStoreApiResponse;
import com.product.exception.ProductServiceException;
import com.product.external.clients.FakeStoreApiClient;
import com.product.mapper.InstanceMapper;
import com.product.models.Product;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "productService")
public class ProductServiceImpl implements ProductService {
    private static final Logger LOGGER = LogManager.getLogger(ProductServiceImpl.class);

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
            LOGGER.info(String.format("Product with id %d is successfully fetched.", id));
            return product;
        } catch (ProductServiceException exception) {
            LOGGER.error(exception.getMessage(), ExceptionUtils.getStackTrace(exception));
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
        LOGGER.info("All the products has been successfully fetched.");
        return productList;
    }

    /**
     * Method provides an interface to create a new object
     *
     * @param product : Product
     * @return Product
     */
    @Override
    public Product createProduct(Product product) {
        FakeStoreApiRequest fakeStoreApiRequest = InstanceMapper.mapProductToFakeStoreApiRequst(product);
        try {
            FakeStoreApiResponse fakeStoreApiResponse = fakeStoreApiClient.createProduct(fakeStoreApiRequest);
            Product toReturn = InstanceMapper.mapFakeStoreApiResponseToProduct(fakeStoreApiResponse);
            return toReturn;
        } catch (ProductServiceException exception) {
            LOGGER.error(exception.getMessage(), ExceptionUtils.getStackTrace(exception));
            return null;
        }
    }

    /**
     * Method provides an interface to update or modify the existing product
     *
     * @param id      Integer
     * @param product Product
     * @return Product
     */
    @Override
    public Product putProduct(Integer id, Product product) {
        Product getProductResponse = this.getProduct(id);
        if (ObjectUtils.isEmpty(getProductResponse)) {
            return null;
        }

        FakeStoreApiRequest fakeStoreApiRequest = InstanceMapper.mapProductToFakeStoreApiRequst(product);
        try {
            FakeStoreApiResponse fakeStoreApiResponse = fakeStoreApiClient.putProduct(id, fakeStoreApiRequest);
            Product resposneProduct = InstanceMapper.mapFakeStoreApiResponseToProduct(fakeStoreApiResponse);
            return resposneProduct;
        } catch (ProductServiceException exception) {
            LOGGER.error(exception.getMessage(), ExceptionUtils.getStackTrace(exception));
            return null;
        }
    }

    /**
     * Method provides an interface to delete an product
     *
     * @param id Integer
     * @return Product
     */
    @Override
    public Product deleteProduct(Integer id) {
        try {
            FakeStoreApiResponse fakeStoreApiResponse = fakeStoreApiClient.deleteProduct(id);
            Product deletedProduct = InstanceMapper.mapFakeStoreApiResponseToProduct(fakeStoreApiResponse);
            return deletedProduct;
        } catch (ProductServiceException exception) {
            LOGGER.error(exception.getMessage(), ExceptionUtils.getStackTrace(exception));
            return null;
        }
    }
}
