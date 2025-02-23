package co.edu.uniquindio.apis.dtos;

import java.time.LocalDateTime;
import java.util.List;

public record EjemploResponseDTO(
        String id,
        String titulo,
        String descripcion,
        String contenido,
        String idCreador,
        List<String> tags,
        String dificultad,
        LocalDateTime fechaCreacion
) {}