package com.snytkine.wiremock_middleware.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/hello")
    public Map<String, String> hello(
            @RequestParam(value = "firstName", required = false, defaultValue = "FN")
                    String firstName,
            @RequestParam(value = "lastName", required = false, defaultValue = "LN")
                    String lastName) {
        Map<String, String> response = new HashMap<>();
        response.put("firstName", firstName);
        response.put("lastName", lastName);
        return response;
    }
}
