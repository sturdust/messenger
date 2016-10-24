package org.test.leverx.rest;

import org.test.leverx.model.Message;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

/**
 * Created by aliaksandr.vashyna on 10/21/2016.
 */
public class RestApiClient {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        Response response = client.target("http://localhost:8080/webapi/messages/2").request().get();
        System.out.println(response.readEntity(Message.class).toString());
    }
}
