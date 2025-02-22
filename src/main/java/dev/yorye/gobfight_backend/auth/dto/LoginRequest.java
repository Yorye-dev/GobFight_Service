package dev.yorye.gobfight_backend.auth.dto;

public record LoginRequest(
        String nickname,
        String password
){
}
