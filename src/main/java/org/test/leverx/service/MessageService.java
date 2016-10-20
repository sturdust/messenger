package org.test.leverx.service;

import org.test.leverx.database.DataBase;
import org.test.leverx.model.Message;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * Created by aliaksandr.vashyna on 10/19/2016.
 */
public class MessageService {
    private Map<Long, Message> messages = DataBase.getMessages();

    public MessageService() {
        messages.put(1L, new Message(1, "Hello world", "sturdust"));
        messages.put(2L, new Message(2, "Hello Jersey", "sturdust"));
    }

    public Message getMessage(long id){
        return  messages.get(id);
    }
    public List<Message> getAllMessages(){
        return new ArrayList<>(messages.values());
    }
    public List<Message> getMessagesForYear(int year){
        List<Message> list = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        for (Message message : messages.values()){
            cal.setTime(message.getCreated());
            if(cal.get(Calendar.YEAR) == year)
                list.add(message);
        }
        return list;
    }
    public List<Message> getMessagesForSize(int start, int size){
        List<Message> list = new ArrayList<>(messages.values());
        if(start + size > list.size()){
            return new ArrayList<>();
        }
        return list.subList(start, start + size);
    }
    public Message updateMessage(Message message){
        if (message.getId() <= 0)
            return null;
        messages.put(message.getId(), message);
        return message;
    }
    public Message addMessage(Message message){
        message.setId(messages.size() + 1);
        messages.put(message.getId(), message);
        return message;
    }
    public Message removeMessaage(long id){
        return messages.remove(id);
    }
}
