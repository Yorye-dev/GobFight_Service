package dev.yorye.gobfight_backend.auth.dto;

public record LoginRequest(
        String nikname,
        String password
){
}
