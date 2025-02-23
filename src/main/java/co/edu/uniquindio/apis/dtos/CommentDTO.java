package co.edu.uniquindio.apis.dtos;

import co.edu.uniquindio.apis.model.enums.CommentState;

import java.util.UUID;

public record CommentDTO (

        String id,
        String authorId,
        String content,
        CommentState state

){

}
