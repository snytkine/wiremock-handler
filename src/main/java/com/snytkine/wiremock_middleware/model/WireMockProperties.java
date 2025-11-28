package com.snytkine.wiremock_middleware.model;

import lombok.Data;

@Data
public class WireMockProperties {
    private boolean enabled = false;
    private Integer containerThreads;
    private Boolean asynchronousResponseEnabled;
    private Integer asynchronousResponseThreads;
    private String rootDirectory;
    private Boolean journalDisabled;
    private Integer maxRequestJournalEntries;
    private Boolean gzipDisabled;
    private Boolean disableOptimizeXmlFactories;
    private Boolean useChunkedTransferEncoding;
    private Boolean stubCorsEnabled;
    private Boolean stubRequestLoggingDisabled;
    private Boolean showcaseNotMatchedRequests;
    private Long maxTemplateCacheEntries;
    private String stringMatchDistanceFunction;
    private Boolean prettyPrintStubs;
    private Boolean globalTemplating;
    private Boolean localTemplating;
}
