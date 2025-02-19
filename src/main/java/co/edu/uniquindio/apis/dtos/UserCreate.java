package co.edu.uniquindio.apis.dtos;

import jakarta.validation.constraints.NotBlank;

public record UserCreate(


        String name,
        String email,
        Integer age

) {
}
