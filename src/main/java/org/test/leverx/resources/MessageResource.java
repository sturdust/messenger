package org.test.leverx.resources;

import org.test.leverx.model.Message;
import org.test.leverx.service.MessageService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by aliaksandr.vashyna on 10/18/2016.
 */
@Path("messages")
public class MessageResource {

    private static MessageService messageService = new MessageService();
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Message> getMessage(){
        return messageService.getAllMessages();
    }
}
