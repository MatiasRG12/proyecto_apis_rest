package co.edu.uniquindio.apis.resources;

import co.edu.uniquindio.apis.dtos.EjemploCreateDTO;
import co.edu.uniquindio.apis.dtos.EjemploResponseDTO;
import co.edu.uniquindio.apis.services.EjemploService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/ejemplos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EjemploResource {

    @Inject
    EjemploService ejemploService;

    @POST
    public Response crearEjemplo(@Valid EjemploCreateDTO ejemploCreateDTO) {
        EjemploResponseDTO ejemploResponseDTO = ejemploService.crearEjemplo(ejemploCreateDTO);
        return Response.status(Response.Status.CREATED).entity(ejemploResponseDTO).build();
    }

    /* Ejemplo de cuerpo de solicitud  (JSON)
    {
    "titulo": "Ejemplo 1",
    "descripcion": "El primer ejemplo",
    "contenido": "El contenido del ejemplo",
    "idCreador": "550e8400-e29b-41d4-a716-446655440000",
    "tags": ["Ejemplo"],
    "dificultad": "Media"
}

http://localhost:8080/ejemplos
     */

    @GET
    public List<EjemploResponseDTO> listaEjemplos() {
        return ejemploService.listaEjemplos();
    }

    @GET
    @Path("/{id}")
    public Response obtenerEjemploPorId(@PathParam("id") String id) {
        EjemploResponseDTO ejemploResponseDTO = ejemploService.obtenerEjemploPorId(id);
        if (ejemploResponseDTO != null) {
            return Response.ok(ejemploResponseDTO).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response actualizarEjemplo(@PathParam("id") String id, @Valid EjemploCreateDTO ejemploCreateDTO) {
        EjemploResponseDTO ejemploResponseDTO = ejemploService.actualizarEjemplo(id, ejemploCreateDTO);
        if (ejemploResponseDTO != null) {
            return Response.ok(ejemploResponseDTO).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response eliminarEjemplo(@PathParam("id") String id) {
        boolean eliminado = ejemploService.eliminarEjemplo(id);
        if (eliminado) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}