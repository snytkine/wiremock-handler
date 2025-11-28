package com.snytkine.wiremock_middleware.service;

import com.snytkine.wiremock_middleware.model.BlogPost;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

@Service
public class BlogService {

    private final RestClient postsRestClient;

    public BlogService(RestClient postsRestClient) {
        this.postsRestClient = postsRestClient;
    }

    public Optional<BlogPost> getPostById(String id) {
        try {
            BlogPost blogPost =
                    postsRestClient.get().uri("/posts/{id}", id).retrieve().body(BlogPost.class);
            return Optional.ofNullable(blogPost);
        } catch (RestClientException e) {
            return Optional.empty();
        }
    }
}
