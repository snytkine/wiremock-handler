package com.snytkine.wiremock_middleware.controller;

import com.snytkine.wiremock_middleware.model.BlogPost;
import com.snytkine.wiremock_middleware.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class BlogPostController {

    private final BlogService blogService;

    public BlogPostController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/article/{id}")
    public ResponseEntity<?> getArticleById(@PathVariable String id) {
        Optional<BlogPost> postOptional = blogService.getPostById(id);
        if (postOptional.isPresent()) {
            return ResponseEntity.ok(postOptional.get());
        } else {
            return new ResponseEntity<>("Article not found by id " + id, HttpStatus.NOT_FOUND);
        }
    }
}
