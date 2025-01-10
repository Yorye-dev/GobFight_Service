package dev.yorye.gobfight_backend.user.mapper;

import dev.yorye.gobfight_backend.auth.dto.RegisterRequest;
import dev.yorye.gobfight_backend.user.dto.UserDto;
import dev.yorye.gobfight_backend.user.entity.User;

public class UserMapper {

    private UserMapper() {
    }

    public static UserDto toUserDto(RegisterRequest request, String hashedPassword) {
        return new UserDto(
                request.nickname(),
                request.email(),
                hashedPassword
        );
    }

    public static User toUser(UserDto userDto) {
        return new User(
                userDto.nickname(),
                userDto.email(),
                userDto.hashedPassword()
        );
    }
}
