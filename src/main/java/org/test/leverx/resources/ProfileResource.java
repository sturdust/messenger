package org.test.leverx.resources;

import org.test.leverx.model.Message;
import org.test.leverx.model.Profile;
import org.test.leverx.service.ProfileService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

/**
 * Created by aliaksandr.vashyna on 10/19/2016.
 */
@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
    private ProfileService profileService = new ProfileService();

    @GET
    public List<Profile> getProfiles(){
        return profileService.getAllProfiles();
    }
    @GET
    @Path("/{profileName}")
    public Profile getProfile(@PathParam("profileName") String profileName){
        return profileService.getProfile(profileName);
    }
    @POST
    public Response addProfile(@Context UriInfo uriInfo, Profile profile){
        Profile newProfile = profileService.addProfile(profile);
        URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(newProfile.getId())).build();
        return Response.created(uri).status(Response.Status.CREATED).entity(newProfile).build();
    }
    @PUT
    @Path("/{profileName}")
    public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile){
        profile.setProfileName(profileName);
        return profileService.updateProfile(profile);
    }
    @DELETE
    @Path("/{profileName}")
    public void deleteProfile(@PathParam("profileName") String profileName){
        profileService.removeProfile(profileName);
    }
}
