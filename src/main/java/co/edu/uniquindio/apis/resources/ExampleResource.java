package co.edu.uniquindio.apis.resources;

import co.edu.uniquindio.apis.dtos.ExampleCreateDTO;
import co.edu.uniquindio.apis.dtos.ExampleResponseDTO;
import co.edu.uniquindio.apis.services.example.ExampleService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/examples")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ExampleResource {

    @Inject
    ExampleService exampleService;

    @POST
    public Response createExample(@Valid ExampleCreateDTO exampleCreateDTO) {
        ExampleResponseDTO exampleResponseDTO = exampleService.createExample(exampleCreateDTO);
        return Response.status(Response.Status.CREATED).entity(exampleResponseDTO).build();
    }


     /* Example request body (JSON)
    {
        "title": "Example 1",
        "description": "The first example",
        "content": "The content of the example",
        "creatorId": "550e8400-e29b-41d4-a716-446655440000",
        "tags": ["Example"],
        "difficulty": "Medium"
    }

    URL: http://localhost:8080/examples
     */


    @GET
    public List<ExampleResponseDTO> listExamples() {
        return exampleService.listExamples();
    }

    @GET
    @Path("/{id}")
    public Response getExampleById(@PathParam("id") Long id) {
        ExampleResponseDTO exampleResponseDTO = exampleService.getExampleById(id);
        if (exampleResponseDTO != null) {
            return Response.ok(exampleResponseDTO).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response updateExample(@PathParam("id") Long id, @Valid ExampleCreateDTO exampleCreateDTO) {
        ExampleResponseDTO exampleResponseDTO = exampleService.updateExample(id, exampleCreateDTO);
        if (exampleResponseDTO != null) {
            return Response.ok(exampleResponseDTO).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteExample(@PathParam("id") Long id) {
        boolean deleted = exampleService.deleteExample(id);
        if (deleted) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}