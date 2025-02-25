package co.edu.uniquindio.apis.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.UUID;

public record UserUpdateRequestDTO(
        @UUID
        String Id,

        @NotBlank(message = "El campo es requerido")
        @Email(message = "Debe ser un email válido")
        String email,


        @NotBlank(message = "El campo es requerido")
        @Size(max = 100, message = "No debe exceder los 100 caracteres")
        String fullName

        ){
}
