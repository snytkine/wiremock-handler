package com.snytkine.wiremock_middleware.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHelloEndpoint() throws Exception {
        mockMvc.perform(get("/hello")
                .param("firstName", "John")
                .param("lastName", "Doe"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("John"))
                .andExpect(jsonPath("$.lastName").value("Doe"));
    }

    @Test
    public void testHelloEndpointWithNoParams() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("FN"))
                .andExpect(jsonPath("$.lastName").value("LN"));
    }

    @Test
    public void testHelloEndpointWithOnlyFirstName() throws Exception {
        mockMvc.perform(get("/hello")
                .param("firstName", "Alice"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Alice"))
                .andExpect(jsonPath("$.lastName").value("LN"));
    }

    @Test
    public void testHelloEndpointWithOnlyLastName() throws Exception {
        mockMvc.perform(get("/hello")
                .param("lastName", "Smith"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("FN"))
                .andExpect(jsonPath("$.lastName").value("Smith"));
    }
}
