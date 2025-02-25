package co.edu.uniquindio.apis.services;

import co.edu.uniquindio.apis.dtos.*;

import java.util.List;

public interface UserService {
    boolean CreateUser(UserCreateDTO userCreateDTO);

    List<UserResponseDTO> GetAllUsers();


    UserResponseDTO GetUserById(String id);


    boolean UpdateUser(UserUpdateRequestDTO updateRequestDTO);

    boolean DeleteUser(String id);

    LoginResponseDTO Login(LoginRequestDTO loginRequestDTO);

    boolean VerifyAccount(AccountVerificationRequestDTO accountVerificationRequestDTO);



}
