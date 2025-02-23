package co.edu.uniquindio.apis.model;

import co.edu.uniquindio.apis.model.enums.CommentState;
import lombok.Data;

import java.util.UUID;

@Data
public class Comment {

    private UUID id;
    private UUID authorId;
    private String content;
    private CommentState state;

}
