package com.snytkine.wiremock_middleware.controller;

import com.snytkine.wiremock_middleware.service.BlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogPostController {

    private final BlogService blogService;

    public BlogPostController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/article/{id}")
    public ResponseEntity<?> getArticleById(@PathVariable String id) {
        return blogService.getPostById(id);
    }
}
