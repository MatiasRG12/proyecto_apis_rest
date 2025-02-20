package co.edu.uniquindio.apis.resources;

import co.edu.uniquindio.apis.dtos.UserCreateDTO;
import co.edu.uniquindio.apis.dtos.UserResponseDTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @GET
    @Path("/{id}")
    public Response GetSingle(@PathParam("id")String id) {
        return null;
    }

    @GET
    public List<UserResponseDTO> GetAll() {
        return null;
    }

    @POST
    public Response Create(@Valid UserCreateDTO user)
    {
        return null;
    }

    @PUT
    @Path("/{id}")
    public Response UpdateUser(@PathParam("id") String id)
    {
        return null;
    }

    @DELETE
    @Path("/{id}")
    public Response DeleteUser(@PathParam("id") String id)
    {
        return null;
    }


}

