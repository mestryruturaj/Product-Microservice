package com.product.external.clients;

import com.product.dto.fakestoreapi.FakeStoreApiRequest;
import com.product.dto.fakestoreapi.FakeStoreApiResponse;
import com.product.exception.ProductServiceException;
import com.product.utils.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

import static com.product.constants.URI.*;

@Component
public class FakeStoreApiClient {
    private final RestTemplate restTemplate;

    @Autowired
    public FakeStoreApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * method interface to get product by id from fakestoreapi.com
     *
     * @param id : Integer
     * @return : FakeStoreApiResponse
     * @throws ProductServiceException when product does not exist
     */
    public FakeStoreApiResponse getProduct(Integer id) throws ProductServiceException {
        ResponseEntity<FakeStoreApiResponse> fakeStoreApiResponseResponseEntity =
                restTemplate.getForEntity(FAKE_STORE_API_GET_PRODUCT_BY_ID, FakeStoreApiResponse.class, id);
        if (Objects.isNull(fakeStoreApiResponseResponseEntity.getBody())) {
            throw new ProductServiceException("Product doesn't exist.");
        }

        return fakeStoreApiResponseResponseEntity.getBody();
    }

    /**
     * method interface to get all products from fakestoreapi.com
     *
     * @return List of FakeStoreApiResponse
     */
    public List<FakeStoreApiResponse> getAllProducts() {
        ResponseEntity<FakeStoreApiResponse[]> fakeStoreApiResponseArrayResponseEntity =
                restTemplate.getForEntity(FAKE_STORE_API_GET_ALL_PRODUCT, FakeStoreApiResponse[].class);
        return ArrayUtils.convertArrayToList(fakeStoreApiResponseArrayResponseEntity.getBody());
    }

    /**
     * Method provides an interface to create a product
     *
     * @param fakeStoreApiRequest : FakeStoreApiRequest
     * @return FakeStoreApiResponse
     */
    public FakeStoreApiResponse createProduct(FakeStoreApiRequest fakeStoreApiRequest) throws ProductServiceException {
        try {
            ResponseEntity<FakeStoreApiResponse> fakeStoreApiResponseResponseEntity =
                    restTemplate.postForEntity(FAKE_STORE_API_CREATE_PRODUCT, fakeStoreApiRequest, FakeStoreApiResponse.class);
            return fakeStoreApiResponseResponseEntity.getBody();
        } catch (RuntimeException exception) {
            throw new ProductServiceException("Product could not be created.");
        }
    }

    /**
     * Method provides an interface to update product details
     *
     * @param id
     * @param fakeStoreApiRequest
     * @return
     */
    public FakeStoreApiResponse putProduct(Integer id, FakeStoreApiRequest fakeStoreApiRequest) throws ProductServiceException {
        try {
            ResponseEntity<FakeStoreApiResponse> fakeStoreApiResponseResponseEntity =
                    restTemplate.exchange(FAKE_STORE_API_PUT_PRODUCT, HttpMethod.PUT, new HttpEntity<>(fakeStoreApiRequest), FakeStoreApiResponse.class, id);
            return fakeStoreApiResponseResponseEntity.getBody();
        } catch (RuntimeException exception) {
            throw new ProductServiceException("Something went wrong while updating product with id " + id + ".");
        }
    }

    public FakeStoreApiResponse deleteProduct(Integer id) throws ProductServiceException {
        try {
            ResponseEntity<FakeStoreApiResponse> fakeStoreApiResponseResponseEntity =
                    restTemplate.exchange(FAKE_STORE_API_DELETE_PRODUCT, HttpMethod.DELETE, null, FakeStoreApiResponse.class, id);
            return fakeStoreApiResponseResponseEntity.getBody();
        }
        catch(RuntimeException exception) {
            throw new ProductServiceException("Something went wrong while deleting product with id " + id + ".");
        }
    }
}
