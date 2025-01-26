package dev.yorye.gobfight_backend.auth.service;

import dev.yorye.gobfight_backend.auth.dto.LoginRequest;
import dev.yorye.gobfight_backend.auth.dto.RegisterRequest;
import dev.yorye.gobfight_backend.auth.dto.TokenResponse;
import dev.yorye.gobfight_backend.user.dto.UserDto;
import dev.yorye.gobfight_backend.user.mapper.UserMapper;
import dev.yorye.gobfight_backend.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImp implements AuthService{

    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @Override
    public TokenResponse register(RegisterRequest request) {

        String hashedPassword = passwordEncoder.encode(request.password());
        UserDto userDto = UserMapper.toUserDto(request,hashedPassword);

        userDto = userService.createNewUser(userDto);

        var jwtToken = jwtService.generateToken(userDto);
        var refreshToken = jwtService.generateRefreshToken(userDto);

        return new TokenResponse(jwtToken, refreshToken);
    }

    @Override
    public TokenResponse login(LoginRequest request) {

        final UserDto userDto = userService.validateUser(request.nickname(), request.password());

        var jwtToken = jwtService.generateToken(userDto);

        var refreshToken = jwtService.generateRefreshToken(userDto);

        return new TokenResponse(jwtToken, refreshToken);
        /*
        TODO Implementar la lógica para el login
        3 Verificar si el usuario tiene un token activo
        4 Si tiene un token activo utilizar ese token
        4 En caso contrario generar un nuevo token
        5 Generar un token de refresco
        6 Persistir el token
        7 Persistir el token de refresco
         */
    }

    private boolean isPasswordCorrect(String password, String hashedPassword){
        return passwordEncoder.matches(password, hashedPassword);
    }
}
