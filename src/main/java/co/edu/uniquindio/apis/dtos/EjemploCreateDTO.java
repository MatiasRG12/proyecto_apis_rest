package co.edu.uniquindio.apis.dtos;

import jakarta.validation.constraints.*;
import java.util.List;

public record EjemploCreateDTO(
        @NotBlank(message = "El título es requerido")
        @Size(max = 100, message = "El título no debe exceder los 100 caracteres")
        String titulo,

        @NotBlank(message = "La descripción es requerida")
        @Size(max = 500, message = "La descripción no debe exceder los 500 caracteres")
        String descripcion,

        @NotBlank(message = "El contenido es requerido")
        String contenido,

        @NotNull(message = "El ID del creador es requerido")
        String idCreador,

        List<String> tags,

        @NotBlank(message = "La dificultad es requerida")
        String dificultad
) {}