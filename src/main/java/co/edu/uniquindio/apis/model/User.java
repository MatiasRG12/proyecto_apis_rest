package co.edu.uniquindio.apis.model;


import co.edu.uniquindio.apis.model.enums.Role;
import co.edu.uniquindio.apis.model.enums.UserState;
import com.aayushatharva.brotli4j.common.annotations.Local;

import java.time.LocalDateTime;

public class User {
    private String id;
    private String nombreCompleto;
    private String email;
    private String password;
    private UserState state;
    private int verificationCode;
    private LocalDateTime creationDate;
    private LocalDateTime codeModificationDate;
    private Role role;

}
