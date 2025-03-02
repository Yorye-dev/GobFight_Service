package dev.yorye.gobfight_backend.auth.dto;

import dev.yorye.gobfight_backend.auth.constants.TokenType;
import dev.yorye.gobfight_backend.user.entity.User;
import lombok.Builder;
import java.util.Objects;

import java.time.LocalDateTime;

@Builder
public record TokenDto(
        Long id,
        Long userId,
        String token,
        LocalDateTime createdAt,
        LocalDateTime expiresAt,
        boolean revoked,
        String type) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TokenDto tokenDto = (TokenDto) o;
        return revoked == tokenDto.revoked &&
                this.id.equals(tokenDto.id) &&
                this.userId.equals(tokenDto.userId) &&
                this.token.equals(tokenDto.token) &&
                this.createdAt.equals(tokenDto.createdAt) &&
                this.expiresAt.equals(tokenDto.expiresAt) &&
                this.type.equals(tokenDto.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, token, createdAt, expiresAt, revoked, type);
    }

}