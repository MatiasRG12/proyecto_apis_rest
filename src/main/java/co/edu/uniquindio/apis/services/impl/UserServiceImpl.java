package co.edu.uniquindio.apis.services.impl;

import co.edu.uniquindio.apis.dtos.*;
import co.edu.uniquindio.apis.services.UserService;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class UserServiceImpl implements UserService {


    @Override
    public boolean CreateUser(UserCreateDTO userCreateDTO) {
        return true;
    }

    @Override
    public List<UserResponseDTO> GetAllUsers() {
        return List.of();
    }

    @Override
    public UserResponseDTO GetUserById(String id) {
        UserResponseDTO user = new UserResponseDTO(UUID.randomUUID().toString(), "John Doe", "john@doe.com", LocalDate.now());
        return user;
    }

    @Override
    public boolean UpdateUser(UserUpdateRequestDTO userUpdateRequestDTO) {
        return true;
    }

    @Override
    public boolean DeleteUser(String id) {
        return true;
    }

    @Override
    public LoginResponseDTO Login(LoginRequestDTO loginRequestDTO) {
        LoginResponseDTO login = new LoginResponseDTO(UUID.randomUUID().toString(), UUID.randomUUID().toString());
        return login;
    }

    @Override
    public boolean VerifyAccount(AccountVerificationRequestDTO accountVerificationRequestDTO) {
        return true;
    }
}
