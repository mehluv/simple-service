package com.example;

import com.example.requests.Login;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(final Login login) {
        boolean isAdmin = false;
        boolean isValid = true;
        if("priya_jha".equals(login.getUsername())) {
            isAdmin = true;
            if(!"chammakchallo".equals(login.getPassword())) {
                isValid = false;
            }
        } else if ("nagarpaalika".equals(login.getUsername())) {
            if(!"bulao".equals(login.getPassword())) {
                isValid = false;
            }
        }
        // PUT the rest of your validation here
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("isAdmin", Boolean.toString(isAdmin));
        responseMap.put("isValid", Boolean.toString(isValid));
        return Response.ok(responseMap, MediaType.APPLICATION_JSON_TYPE).build();
    }
}
