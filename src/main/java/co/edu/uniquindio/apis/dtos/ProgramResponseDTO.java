package co.edu.uniquindio.apis.dtos;

import java.time.LocalDateTime;
import java.util.List;
import co.edu.uniquindio.apis.model.Comment;

public record ProgramResponseDTO (

        Long id,
        String title,
        String description,
        String content,
        String creatorId,
        List<Comment> comments,
        LocalDateTime creationDate

){

}
