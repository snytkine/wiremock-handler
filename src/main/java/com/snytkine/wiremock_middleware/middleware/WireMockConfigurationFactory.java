package com.snytkine.wiremock_middleware.middleware;

import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.snytkine.wiremock_middleware.model.WireMockProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class WireMockConfigurationFactory {

    private final WireMockProperties wireMockProperties;

    public WireMockConfigurationFactory(WireMockProperties wireMockProperties) {
        this.wireMockProperties = wireMockProperties;
    }

    @Bean
    public WireMockConfiguration wireMockConfiguration() {
        WireMockConfiguration wireMockConfiguration = new WireMockConfiguration();
        
        Optional.ofNullable(wireMockProperties.getContainerThreads()).ifPresent(wireMockConfiguration::containerThreads);
        Optional.ofNullable(wireMockProperties.getAsynchronousResponseThreads()).ifPresent(wireMockConfiguration::asynchronousResponseThreads);
        Optional.ofNullable(wireMockProperties.getMaxRequestJournalEntries()).ifPresent(wireMockConfiguration::maxRequestJournalEntries);
    

        return wireMockConfiguration;
    }
}
