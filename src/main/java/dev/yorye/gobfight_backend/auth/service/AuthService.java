package dev.yorye.gobfight_backend.auth.service;

import dev.yorye.gobfight_backend.auth.dto.RegisterRequest;
import dev.yorye.gobfight_backend.auth.dto.TokenResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    //Inyectar el servicio de User

    public TokenResponse register(RegisterRequest request) {
        // LLamar a los servicios del paquete Usuario
        //UserService.registerUser(UserDTO)
    }
}
