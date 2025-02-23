package co.edu.uniquindio.apis.dtos;

import java.time.LocalDateTime;
import java.util.List;

public record ProgramResponseDTO(

    String id,
    String tittle,
    String description,
    String content,
    String authorId,
    List<CommentDTO> commets,
    LocalDateTime creationDate

) {
}
