package com.product.service;

import com.product.models.Product;
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
    public Product getProduct(Integer id);

    /**
     * Method is used to fetch all the products available on fakestoreapi
     *
     * @return List of FakeStoreApiProductResponseDto
     */
    public List<Product> getAllProducts();

    /**
     * Method provides an interface to create a new object
     *
     * @param product : Product
     * @return Product
     */
    public Product createProduct(Product product);

    /**
     * Method provides an interface to update or modify the existing product
     *
     * @param id      Integer
     * @param product Product
     * @return Product
     */
    public Product putProduct(Integer id, Product product);


    /**
     * Method provides an interface to delete an product
     *
     * @param id Integer
     * @return Product
     */
    public Product deleteProduct(Integer id);
}
