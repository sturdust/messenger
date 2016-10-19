package org.test.leverx.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by aliaksandr.vashyna on 10/18/2016.
 */
@Path("messages")
public class MessageResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage(){
        return "Hello World!";
    }
}
