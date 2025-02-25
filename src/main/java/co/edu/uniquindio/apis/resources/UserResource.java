package co.edu.uniquindio.apis.resources;

import co.edu.uniquindio.apis.dtos.*;
import co.edu.uniquindio.apis.services.UserService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {


    @Inject
    UserService userService;

    @GET
    @Path("/{id}")
    public Response GetSingle(@PathParam("id")String id) {
        var user = userService.GetUserById(id);
        return Response.ok().entity(user).build();
    }

    @GET
    public Response GetAll() {
        var users = userService.GetAllUsers();
        return Response.ok().entity(users).build();
    }

    @POST
    public Response Create(@Valid UserCreateDTO userCreateDTO)
    {
        var user = userService.CreateUser(userCreateDTO);
        return Response.ok().entity(user).build();
    }

    @PUT
    @Path("/{id}")
    public Response UpdateUser(@Valid UserUpdateRequestDTO userUpdateDTO)
    {
        var user = userService.UpdateUser(userUpdateDTO);
        return Response.ok().entity(user).build();
    }

    @DELETE
    @Path("/{id}")
    public Response DeleteUser(@PathParam("id") String id)
    {
        var user = userService.DeleteUser(id);
        return Response.ok().entity(user).build();
    }

    @POST
    @Path("/login")
    public Response LoginRequest (@Valid LoginRequestDTO loginRequest)
    {
        if (loginRequest.email() == "guest@gmail.com" && loginRequest.password() == "guest"){
            var response = new LoginResponseDTO(UUID.randomUUID().toString(), loginRequest.password());
            return Response.ok(response).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    @POST
    @Path("/verify")
    public Response VerifyAccount (@Valid AccountVerificationRequestDTO accountVerificationRequestDTO)
    {
        if (accountVerificationRequestDTO.email() == "guest@gmail.com" && accountVerificationRequestDTO.verificationCode() == 1122){
            return Response.ok().entity(true).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }



}

