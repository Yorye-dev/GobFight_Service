package dev.yorye.gobfight_backend.auth.service;

import dev.yorye.gobfight_backend.auth.dto.RegisterRequest;
import dev.yorye.gobfight_backend.auth.dto.TokenResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    //Inyectar el servicio de User

    TokenResponse register(RegisterRequest request);

}
