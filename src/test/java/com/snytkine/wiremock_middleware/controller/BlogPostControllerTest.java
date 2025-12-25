package com.snytkine.wiremock_middleware.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.snytkine.wiremock_middleware.model.BlogPost;
import com.snytkine.wiremock_middleware.service.BlogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(BlogPostController.class)
class BlogPostControllerTest {

    @Autowired private MockMvc mockMvc;

    @MockBean private BlogService blogService;

    @Test
    void controllerForwardsStatusAndHeadersFromService() throws Exception {
        BlogPost post = new BlogPost(1, 1, "Title", "Body");
        ResponseEntity<BlogPost> response =
                ResponseEntity.status(202).header("X-Relay", "ok").body(post);

        when(blogService.getPostById("1")).thenReturn(response);

        mockMvc.perform(get("/article/1"))
                .andExpect(status().isAccepted())
                .andExpect(header().string("X-Relay", "ok"))
                .andExpect(jsonPath("$.title").value("Title"));
    }
}
