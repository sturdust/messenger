package org.test.leverx.model;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by aliaksandr.vashyna on 10/19/2016.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"id", "message", "created", "author"})
@XmlRootElement
public class Message {
    @Getter
    @Setter
    private long id;
    @Getter
    @Setter
    private String message;
    @Getter
    @Setter
    private Date created;
    @Getter
    @Setter
    private String author;
    @Setter
    private Map<Long, Comment> comments = new HashMap<>();

    public Message(long id, String message, String author) {
        this.id = id;
        this.message = message;
        this.author = author;
        this.created = new Date();
    }
    @XmlTransient
    public Map<Long, Comment> getComments() {
        return comments;
    }
}
