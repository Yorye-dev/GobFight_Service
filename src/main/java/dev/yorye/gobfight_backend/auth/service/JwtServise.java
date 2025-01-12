package dev.yorye.gobfight_backend.auth.service;

import dev.yorye.gobfight_backend.user.dto.UserDto;

public interface JwtServise {
    String generateToken(final UserDto user);

    boolean vaidateToken(final String token);

    String refreshToken(final String token);

    UserDto getUserFromToken(final String token);

}
