package org.test.leverx.rest;


import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import org.glassfish.jersey.internal.util.Base64;

/**
 * Created by aliaksandr.vashyna on 10/24/2016.
 */
@Provider
public class SecurityFilter implements ContainerRequestFilter {
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String SECURITY_PREFIX = "messages";
    private static final String AUTHORIZATION_PREFIX = "Basic ";

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        if (requestContext.getUriInfo().getAbsolutePath().toString().contains(SECURITY_PREFIX)) {
            if (requestContext.getHeaders() != null && !requestContext.getHeaders().get(AUTHORIZATION_HEADER).isEmpty()) {
                String encodedAuthStr = requestContext.getHeaders().get(AUTHORIZATION_HEADER).get(0).replace(AUTHORIZATION_PREFIX, "");
                String decodedStr = Base64.decodeAsString(encodedAuthStr);
                String[] nameAndPassword = decodedStr.split(":");
                String userName = nameAndPassword[0];
                String password = nameAndPassword[1];
                if(userName.equals("user") && password.equals("password"))
                    return;
            }
            Response response = Response.status(Response.Status.UNAUTHORIZED).entity("No authorization. API is secured").build();
            requestContext.abortWith(response);
        }
    }
}
