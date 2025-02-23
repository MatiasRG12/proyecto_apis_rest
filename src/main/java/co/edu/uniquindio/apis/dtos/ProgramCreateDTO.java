package co.edu.uniquindio.apis.dtos;

import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import co.edu.uniquindio.apis.model.Comment;



public record ProgramCreateDTO(
    UUID id,

    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title must not exceed 100 characters")
    String title,

    @NotBlank(message = "Description is required")
    @Size(max = 500, message = "Description must not exceed 500 characters")
    String description,

    @NotBlank(message = "Content is required")
    String content,

    @NotNull(message = "Creator ID is required")
    UUID creatorId,

    List<Comment> comments,

    LocalDateTime creationDate
) {}