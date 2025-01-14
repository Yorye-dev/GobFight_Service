package dev.yorye.gobfight_backend.auth.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
public record TokenDto(
        String token,
        LocalDateTime createdAt,
        LocalDateTime expiresAt,
        boolean active) { //Se utiliza?

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TokenDto tokenDto = (TokenDto) obj;
        return token.equals(tokenDto.token) && createdAt.equals(tokenDto.createdAt) && expiresAt.equals(tokenDto.expiresAt);
    }

}