package org.test.leverx.service;

import org.test.leverx.model.Message;

import java.util.Arrays;
import java.util.List;

/**
 * Created by aliaksandr.vashyna on 10/19/2016.
 */
public class MessageService {
    public List<Message> getAllMessages(){
        Message m1 = new Message(1,"Hello", "Mike");
        Message m2 = new Message(2,"Buye", "Tom");

        return Arrays.asList(m1,m2);
    }
}
