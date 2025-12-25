package com.snytkine.wiremock_middleware.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.snytkine.wiremock_middleware.model.BlogPost;
import java.io.IOException;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

class BlogServiceTest {

    private MockWebServer mockWebServer;

    @BeforeEach
    void setUp() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
    }

    @AfterEach
    void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    void getPostById_forwardsStatusAndHeaders() {
        String body = "{\"userId\":1,\"id\":1,\"title\":\"Title\",\"body\":\"Body\"}";
        MockResponse mockResponse =
                new MockResponse()
                        .setResponseCode(201)
                        .addHeader("X-Test", "yes")
                        .setBody(body)
                        .addHeader("Content-Type", "application/json");

        mockWebServer.enqueue(mockResponse);

        String baseUrl = mockWebServer.url("/").toString();
        RestClient restClient = RestClient.builder().baseUrl(baseUrl).build();
        BlogService service = new BlogService(restClient);

        ResponseEntity<BlogPost> response = service.getPostById("1");

        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("yes", response.getHeaders().getFirst("X-Test"));
        assertNotNull(response.getBody());
        assertEquals("Title", response.getBody().getTitle());
    }
}
