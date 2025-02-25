package co.edu.uniquindio.apis.model;

import co.edu.uniquindio.apis.model.enums.CommentState;
import lombok.Data;

import java.util.UUID;

@Data
public class Comment {

    private String id;
    private String authorId;
    private String content;
    private CommentState state;

}
