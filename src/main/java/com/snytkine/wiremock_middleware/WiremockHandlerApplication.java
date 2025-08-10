package com.snytkine.wiremock_middleware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WiremockHandlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WiremockHandlerApplication.class, args);
		//WireMockServer wiremock = new WireMockServer(WireMockSpring.options().port(8898));
		//wiremock.start();
		//System.out.println("~~~~~~~~~~~~~ wiremock started on port " + wiremock.port());

	}

}
