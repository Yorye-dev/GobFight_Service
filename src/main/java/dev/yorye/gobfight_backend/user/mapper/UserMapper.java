package dev.yorye.gobfight_backend.user.mapper;

import dev.yorye.gobfight_backend.auth.dto.RegisterRequest;
import dev.yorye.gobfight_backend.user.dto.UserDto;
import dev.yorye.gobfight_backend.user.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    private UserMapper() {
    }

    public static UserDto toUserDto(RegisterRequest request, String hashedPassword) {
        return new UserDto(
                null,
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

    public static UserDto toUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getNickname(),
                user.getEmail(),
                user.getPassword()
        );
    }

    public static List<UserDto> UsersListToUserDtosList(List<User> users) {
        return users.stream()
                .map(UserMapper::toUserDto)
                .collect(Collectors.toList());
    }
}
