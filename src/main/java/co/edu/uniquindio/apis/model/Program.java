package co.edu.uniquindio.apis.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "program")
@Data
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String title;
    private String description;
    private String content;
    private String creatorId;
    private List<Comment> comments;
    private LocalDateTime creationDate;

}
