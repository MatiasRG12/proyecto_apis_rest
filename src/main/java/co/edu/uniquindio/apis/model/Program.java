package co.edu.uniquindio.apis.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class Program {

    private UUID id;
    private String title;
    private String description;
    private String content;
    private UUID creatorId;
    private List<Comment> comments;
    private LocalDateTime creationDate;

}
