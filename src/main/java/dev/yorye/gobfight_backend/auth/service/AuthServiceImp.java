package dev.yorye.gobfight_backend.auth.service;

import dev.yorye.gobfight_backend.auth.dto.RegisterRequest;
import dev.yorye.gobfight_backend.auth.dto.TokenResponse;
import dev.yorye.gobfight_backend.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static dev.yorye.gobfight_backend.user.mapper.UserMapper.toUserDto;

@Service
public class AuthServiceImp implements AuthService{
    @Autowired
    private PasswordEncoder passwordEncoder;
    private UserService userService;

    @Override
    public TokenResponse register(RegisterRequest request) {

        String hashedPassword = passwordEncoder.encode(request.password());

        userService.createNewUser(toUserDto(request,hashedPassword));
        //TODO
        // Falta toda la capa de persistencia de los usuarios y analizar si se quiere persistir en BDD el token generado.

        return null; // Implementar JWT, ya que tiene que retornar un token.
    }

}
