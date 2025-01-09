package dev.yorye.gobfight_backend.user.dto;

public record UserDto(
        String username,
        String email,
        String hashedPassword) {
}

