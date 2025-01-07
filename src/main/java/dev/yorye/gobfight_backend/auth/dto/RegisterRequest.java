package dev.yorye.gobfight_backend.auth.dto;

public record RegisterRequest(
        String email,
        String password,
        String name
){
}
