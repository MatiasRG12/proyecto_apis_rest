package co.edu.uniquindio.apis.model;


import co.edu.uniquindio.apis.model.enums.Role;
import co.edu.uniquindio.apis.model.enums.UserState;
import com.aayushatharva.brotli4j.common.annotations.Local;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "user")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserState getState() {
        return state;
    }

    public void setState(UserState state) {
        this.state = state;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public int getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(int verificationCode) {
        this.verificationCode = verificationCode;
    }

    public LocalDateTime getCodeModificationDate() {
        return codeModificationDate;
    }

    public void setCodeModificationDate(LocalDateTime codeModificationDate) {
        this.codeModificationDate = codeModificationDate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
