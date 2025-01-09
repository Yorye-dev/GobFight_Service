package dev.yorye.gobfight_backend.user.mapper;

import dev.yorye.gobfight_backend.auth.dto.RegisterRequest;
import dev.yorye.gobfight_backend.user.dto.UserDto;

public class UserMapper {

    private UserMapper() {
    }

    public static UserDto toUserDto(RegisterRequest request, String hashedPassword) {
        return new UserDto(
                request.name(),
                request.email(),
                hashedPassword
        );
    }
}
