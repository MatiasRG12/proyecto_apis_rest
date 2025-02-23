package co.edu.uniquindio.apis.resources;


import co.edu.uniquindio.apis.dtos.CommentDTO;
import co.edu.uniquindio.apis.dtos.ProgramCreateDTO;
import co.edu.uniquindio.apis.dtos.ProgramResponseDTO;
import co.edu.uniquindio.apis.services.ProgramService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;


@Path("/Programs")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProgramsResource {

    @Inject
    ProgramService programService;

    @POST
    public Response createProgram(ProgramCreateDTO programCreateDTO){
        var response = programService.createProgram(programCreateDTO);
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    @GET
    public Response getAllPrograms(){
        List<ProgramResponseDTO> programs = programService.getAllPrograms();
        return Response.status(Response.Status.OK).entity(programs).build();
    }

    @GET
    @Path("/{id}/comments")
    public Response getComments(@PathParam("id") String id , @QueryParam("offset") int offset, @QueryParam("limit") int limit ){
        List<CommentDTO> comments = programService.getAllComments(id, offset, limit);
        return Response.status(Response.Status.OK).entity(comments).build();
    }

    @GET
    @Path("/{id}")
    public Response getProgramById(@PathParam("id") String id){
        ProgramResponseDTO program = programService.getById(id);
        return Response.status(Response.Status.OK).entity(program).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateProgram(@PathParam("id")String id, ProgramCreateDTO programCreateDTO){
        var response = programService.updateProgram(id, programCreateDTO);
        return Response.status(Response.Status.OK).entity(response).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProgram(@PathParam("id")String id){
        var response = programService.deleteProgram(id);
        return Response.status(Response.Status.OK).entity(response).build();
    }




}
