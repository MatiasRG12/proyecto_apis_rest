package co.edu.uniquindio.apis.exceptions.mappers;

import co.edu.uniquindio.apis.dtos.error.ErrorResponseDTO;
import co.edu.uniquindio.apis.exceptions.exceptions.UnexpectedErrorException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class UnexpectedErrorExceptionMapper implements ExceptionMapper<UnexpectedErrorException> {
    @Override
    public Response toResponse(UnexpectedErrorException exception) {
        var response = new ErrorResponseDTO("Unexpected error", exception.getMessage());
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
    }

}
