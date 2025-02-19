package co.edu.uniquindio.apis.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import co.edu.uniquindio.apis.dtos.*;
import jakarta.ws.rs.core.Response;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserController {

    @GET
    @Path("/{id}")
    public Response create(@PathParam("id")String id) {
        return null;
    }

}
