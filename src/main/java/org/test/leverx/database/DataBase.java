package org.test.leverx.database;

import org.test.leverx.model.Message;
import org.test.leverx.model.Profile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aliaksandr.vashyna on 10/19/2016.
 */
public class DataBase {
    private static Map<Long, Message> messages = new HashMap<>();
    private static Map<String, Profile> profiles = new HashMap<>();

    public static Map<Long, Message> getMessages() {
        return messages;
    }

    public static Map<String, Profile> getProfiles() {
        return profiles;
    }
}
