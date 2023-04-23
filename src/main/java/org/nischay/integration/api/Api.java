package org.nischay.integration.api;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;

public class Api {

    private static final String DEFAULT_BASE_URL = "https://pokeapi.co/api/v2";
    private final String baseUrl;
    private final Client httpClient;

    public Api(String baseUrl) {
        this.baseUrl = baseUrl;
        this.httpClient = createHttpClient();
    }
    public Api() {
        this(DEFAULT_BASE_URL);
    }

    private Client createHttpClient() {
        return ClientBuilder.newClient();
    }

    public String getResponse(String endpoint) {
        return httpClient.target(DEFAULT_BASE_URL + endpoint).request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
    }

}
