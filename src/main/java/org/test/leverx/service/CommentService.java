package org.test.leverx.service;

import org.test.leverx.database.DataBase;
import org.test.leverx.model.Comment;
import org.test.leverx.model.Message;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by aliaksandr.vashyna on 10/20/2016.
 */
public class CommentService {
    private Map<Long, Message> messages = DataBase.getMessages();

    public Comment getComment(long messageId, long commentId){
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return  comments.get(commentId);
    }
    public ArrayList<Comment> getAllComments(long messageId){
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return new ArrayList<>(comments.values());
    }
    public Comment updateComment(long messageId, Comment comment){
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        if (comment.getId() <= 0)
            return null;
        comments.put(comment.getId(), comment);
        return comment;
    }
    public Comment addComment(long messageId, Comment comment){
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        comment.setId(comments.size() + 1);
        comments.put(comment.getId(), comment);
        return comment;
    }
    public Comment removeComment(long messageId, long commentId){
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return comments.remove(commentId);
    }
}
