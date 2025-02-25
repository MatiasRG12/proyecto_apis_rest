package co.edu.uniquindio.apis.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class Program {

    private String id;
    private String title;
    private String description;
    private String content;
    private String creatorId;
    private List<Comment> comments;
    private LocalDateTime creationDate;

}
