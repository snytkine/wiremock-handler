package com.snytkine.wiremock_middleware.service;

import net.snytkine.springboot.wiremock_middleware.WireMockInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class BlogPostsRestClient {
    WireMockInterceptor wireMockMiddleware;

    public BlogPostsRestClient(WireMockInterceptor wireMockMiddleware) {
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
