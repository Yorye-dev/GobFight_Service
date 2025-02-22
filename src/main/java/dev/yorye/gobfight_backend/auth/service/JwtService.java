package dev.yorye.gobfight_backend.auth.service;

import dev.yorye.gobfight_backend.user.dto.UserDto;

public interface JwtService {
    String generateToken(final UserDto user);

    boolean isValidateToken(final String token, UserDto user);

    String generateRefreshToken(final UserDto user);

    String generateRefreshToken(final String token);

    UserDto getUserDtoFromToken(final String token);

    boolean isTokenExpired(final String token);

    void deleteToken(final String token);



}
