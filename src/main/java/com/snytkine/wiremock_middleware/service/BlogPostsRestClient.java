package com.snytkine.wiremock_middleware.service;

import com.snytkine.wiremock_middleware.middleware.WireMockMiddleware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class BlogPostsRestClient {
    WireMockMiddleware wireMockMiddleware;

    public BlogPostsRestClient(WireMockMiddleware wireMockMiddleware) {
        this.wireMockMiddleware = wireMockMiddleware;
    }

    @Bean
    public RestClient postsRestClient() {
        return RestClient.builder()
                // TODO: Externalize this URL into application.properties
                .baseUrl("https://jsonplaceholder.typicode.com")
                .requestInterceptor(wireMockMiddleware)
                .build();
    }
}
