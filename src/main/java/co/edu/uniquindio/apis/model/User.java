package co.edu.uniquindio.apis.model;


import co.edu.uniquindio.apis.model.enums.Role;
import co.edu.uniquindio.apis.model.enums.UserState;
import com.aayushatharva.brotli4j.common.annotations.Local;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String email;
    private String password;
    private UserState state;
    private int verificationCode;
    private LocalDateTime creationDate;
    private LocalDateTime codeModificationDate;
    private Role role;

}
