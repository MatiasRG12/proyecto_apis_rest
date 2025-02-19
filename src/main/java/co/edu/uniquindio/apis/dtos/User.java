package co.edu.uniquindio.apis.dtos;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record User(

        @NotBlank(message = "ID cannot be empty")
        String id,
        String name,
        @Email(message = "valid email required")
        String email,
        LocalDate createdAt
) {

}
