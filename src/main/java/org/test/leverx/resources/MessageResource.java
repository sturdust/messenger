package org.test.leverx.resources;

import org.test.leverx.model.Message;
import org.test.leverx.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

/**
 * Created by aliaksandr.vashyna on 10/18/2016.
 */
@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

    private static MessageService messageService = new MessageService();
    @GET
    public List<Message> getMessages(@QueryParam("year") int year,
                                     @QueryParam("start") int start,
                                     @QueryParam("size") int size){
        if (year > 0)
            return messageService.getMessagesForYear(year);
        if(start >= 0 && size > 0)
            return messageService.getMessagesForSize(start, size);

        return messageService.getAllMessages();
    }
    @GET
    @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId") long messageId){
        return messageService.getMessage(messageId);
    }
    @POST
    public Response addMessage(@Context UriInfo uriInfo, Message message){
        Message newMessage = messageService.addMessage(message);
        URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(newMessage.getId())).build();
        return Response.created(uri).status(Response.Status.CREATED).entity(newMessage).build();
    }
    @PUT
    @Path("/{messageId}")
    public Message updateMessage(@PathParam("messageId") long messageId, Message message){
        message.setId(messageId);
        return messageService.updateMessage(message);
    }
    @DELETE
    @Path("/{messageId}")
    public void deleteMessage(@PathParam("messageId") long messageId){
        messageService.removeMessaage(messageId);
    }

    @Path("/{messageId}/comments")
    public CommentResource getCommentResource(){
        return new CommentResource();
    }
}
