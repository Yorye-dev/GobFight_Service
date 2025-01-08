package dev.yorye.gobfight_backend.auth.service;

import dev.yorye.gobfight_backend.auth.dto.RegisterRequest;
import dev.yorye.gobfight_backend.auth.dto.TokenResponse;

public class AuthServiceImp implements AuthService{

    @Override
    public TokenResponse register(RegisterRequest request) {

        //UserService.registerUser(UserDTO)
        // TODO
        // Hay que primero montar el Usuario DTO y luego, llamar a la implementación del servicio de paquete User
        return null;
    }

}
