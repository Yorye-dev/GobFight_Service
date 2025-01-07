package dev.yorye.gobfight_backend.auth.dto;

public record LoginRequest(
        String name,
        String password
){
}
