package io.github.dougllasfps.quarkussocial.rest;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.Produces;
import io.github.dougllasfps.quarkussocial.domain.User;
import io.github.dougllasfps.quarkussocial.rest.dto.CreateUserRequest;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @POST 
    @Transactional       
    public Response createUser (CreateUserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        user.setAge(userRequest.getAge());
        user.persist();
        
        
        return Response.ok(user).build();
    }

    @GET
    public Response listAllUsers() {
        return Response.ok().build();
    }
}
