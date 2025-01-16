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

        userService.createNewUser(userDto); // Persisntecia del suario en base de datos

        var jwtToken = jwtService.generateToken(userDto);

        return new TokenResponse(jwtToken, jwtToken);
        //TODO
       // Es necesario el persistir el token
        // 1. T

    }

    @Override
    public TokenResponse login(LoginRequest request) {

        final UserDto userDto = userService.validateUser(request.nickname(), request.password());

        var jwtToken = jwtService.generateToken(userDto);

        return new TokenResponse(jwtToken, jwtToken);
        //TODO
        /*
        1 Verificar si el usuario existe en la base de datos // userService.getUserByNickname(request.nickname());
        2 Verificar si la contraseña es correcta // isPasswordCorrect(request.password(), userDto.password());
        3 Verificar si el usuario tiene un token activo
        4 Si tiene un token activo utilizar ese token
        4 En caso contrario generar un nuevo token
         */
    }

    private boolean isPasswordCorrect(String password, String hashedPassword){
        return passwordEncoder.matches(password, hashedPassword);
    }
}
