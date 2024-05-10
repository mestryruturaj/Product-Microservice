package com.product.external.clients;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.models.com.jsonplaceholder.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Component
public class JsonPlaceholderApiClient {
    private ObjectMapper objectMapper;

    @Autowired
    public JsonPlaceholderApiClient(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<Post> getAllPost() {
        URI uri = URI.create("https://jsonplaceholder.typicode.com/posts");

        HttpRequest getRequest = HttpRequest.newBuilder()
                .header("accept", "application/json")
                .GET()
                .uri(uri)
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        try {
            HttpResponse<String> httpResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

            List<Post> postList = objectMapper.readValue(httpResponse.body(), new TypeReference<List<Post>>() {
            });
            return postList;
        } catch (JsonMappingException exception) {
            System.out.println("Exception occurred during sending a request");
        } catch (IOException |
                 InterruptedException exception) {
            System.out.println("Exception occurred during sending a request.");
        }

        return null;
    }
}
