package org.test.leverx.resources;

import org.test.leverx.model.Comment;
import org.test.leverx.service.CommentService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.ArrayList;

/**
 * Created by aliaksandr.vashyna on 10/20/2016.
 */
//this class is subresource of message resource
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {
    private CommentService commentService = new CommentService();
    @GET
    public ArrayList<Comment> getAllComments(@PathParam("messageId") long messageId){
        return commentService.getAllComments(messageId);
    }
    @GET
    @Path("/{commentId}")
    public Comment getCommentById(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId){
        return commentService.getComment(messageId, commentId);
    }
    @POST
    public Response addComment(@Context UriInfo uriInfo, @PathParam("messageId") long messageId, Comment comment){
        Comment newComment = commentService.addComment(messageId, comment);
        URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(newComment.getId())).build();
        return Response.created(uri).status(Response.Status.CREATED).entity(newComment).build();
    }
    @PUT
    @Path("/{commentId}")
    public Comment updateComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId, Comment comment){
        comment.setId(commentId);
        return commentService.updateComment(messageId, comment);
    }
    @DELETE
    @Path("/{commentId}")
    public void deleteComment(@PathParam("messageId") long messageId,  @PathParam("commentId") long commentId){
        commentService.removeComment(messageId, commentId);
    }
}
