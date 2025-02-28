package co.edu.uniquindio.apis.exceptions.mappers;

import co.edu.uniquindio.apis.dtos.error.ErrorResponseDTO;
import co.edu.uniquindio.apis.exceptions.exceptions.UnauthorizedException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class UnauthorizedExceptionMapper implements ExceptionMapper<UnauthorizedException> {
    @Override
    public Response toResponse (UnauthorizedException exception){
        var response = new ErrorResponseDTO("Unauthorized", exception.getMessage());
        return Response.status(Response.Status.UNAUTHORIZED).entity(response).build();
    }
}
