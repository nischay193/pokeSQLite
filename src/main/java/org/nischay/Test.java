package org.nischay;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import org.nischay.core.table_annotations.Table;
import org.nischay.integration.api.Api;
import org.nischay.integration.model.Move;

public class Test {
    public static void main(String[] args) {
        Class<?> type = Object.class;
        System.out.println(type.getSimpleName());

        Client client = ClientBuilder.newClient();
        WebTarget webTarget
                = client.target("https://pokeapi.co/api/v2/pokemon/ditto");
        Invocation.Builder invocationBuilder
                = webTarget.request(MediaType.APPLICATION_JSON);
        String response = invocationBuilder.get(String.class);
        System.out.println(response);
    }
}
