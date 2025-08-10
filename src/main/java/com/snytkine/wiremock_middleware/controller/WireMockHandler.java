package com.snytkine.wiremock_middleware.controller;
import org.springframework.cloud.contract.wiremock.WireMockSpring;

import com.github.tomakehurst.wiremock.WireMockServer;

public class WireMockHandler {


    public void handleRequests(){

        WireMockServer wiremock = new WireMockServer(WireMockSpring.options().dynamicPort());

    }
    
}
