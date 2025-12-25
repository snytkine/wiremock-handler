package com.snytkine.wiremock_middleware.service;

import com.snytkine.wiremock_middleware.model.BlogPost;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

@Service
public class BlogService {

    private final RestClient postsRestClient;

    public BlogService(RestClient postsRestClient) {
        this.postsRestClient = postsRestClient;
    }

    public ResponseEntity<BlogPost> getPostById(String id) {
        try {
            ResponseEntity<BlogPost> response =
                    postsRestClient
                            .get()
                            .uri("/posts/{id}", id)
                            .retrieve()
                            .toEntity(BlogPost.class);
            return response;
        } catch (RestClientException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
    }
}
