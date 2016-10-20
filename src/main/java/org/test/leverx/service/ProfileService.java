package org.test.leverx.service;

import org.test.leverx.database.DataBase;
import org.test.leverx.model.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by aliaksandr.vashyna on 10/19/2016.
 */
public class ProfileService {
    private Map<String, Profile> profiles = DataBase.getProfiles();

    public ProfileService() {
        profiles.put("sturdust", new Profile(1,"sturdust", "Ivan", "Ivanov"));
    }

    public Profile getProfile(String profileName){
        return  profiles.get(profileName);
    }
    public List<Profile> getAllProfiles(){
        return new ArrayList<>(profiles.values());
    }
    public Profile updateProfile(Profile profile){
        if (profile.getProfileName().isEmpty())
            return null;
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }
    public Profile addProfile(Profile profile){
        profile.setId(profiles.size() + 1);
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }
    public Profile removeProfile(String profileName){
        return profiles.remove(profileName);
    }
}
