package com.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductMicroserviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductMicroserviceApplication.class, args);
        /*TODO: Unccomment for the HttpClient demonstration*/
        /*
        ObjectMapper objectMapper = new ObjectMapper();
        JsonPlaceholderApiClient jsonPlaceholderApiClient = new JsonPlaceholderApiClient(objectMapper);
        List<Post> postList = jsonPlaceholderApiClient.getAllPost();
        postList.stream().forEach(System.out::println);
        */
    }
}
