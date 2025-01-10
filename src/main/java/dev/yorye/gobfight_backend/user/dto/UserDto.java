package dev.yorye.gobfight_backend.user.dto;

public record UserDto(
        String nickname,
        String email,
        String hashedPassword) {
}

