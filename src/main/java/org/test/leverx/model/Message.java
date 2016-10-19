package org.test.leverx.model;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

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

    public Message(long id, String message, String author) {
        this.id = id;
        this.message = message;
        this.author = author;
        this.created = new Date();
    }
}
