package co.edu.uniquindio.apis.resources;

import co.edu.uniquindio.apis.model.Program;
import co.edu.uniquindio.apis.model.Comment;
import co.edu.uniquindio.apis.dtos.ProgramCreateDTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

@Path("/programs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProgramResource {

    @POST
    public Response createProgram(ProgramCreateDTO programCreateDTO) {
        Program program = new Program(); 
        return Response.status(Response.Status.CREATED).entity(program).build();
    }

    @GET
    public Response getAllPrograms(@QueryParam("orderByCreationDate") @DefaultValue("false") boolean orderByCreationDate) {
        List<Program> programs = List.of(); 
        return Response.ok(programs).build();
    }

    @GET
    @Path("/{id}/comments")
    public Response getProgramComments(@PathParam("id") UUID id, @QueryParam("offset") @DefaultValue("0") int offset, @QueryParam("limit") @DefaultValue("10") int limit) {
        List<Comment> comments = List.of(); 
        return Response.ok(comments).build();
    }

    @GET
    @Path("/{id}")
    public Response getProgramById(@PathParam("id") UUID id) {
        Program program = new Program(); 
        return Response.ok(program).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateProgram(@PathParam("id") UUID id, ProgramCreateDTO programCreateDTO) {
        Program program = new Program(); 
        return Response.ok(program).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProgram(@PathParam("id") UUID id) {
        return Response.noContent().build();
    }
}
