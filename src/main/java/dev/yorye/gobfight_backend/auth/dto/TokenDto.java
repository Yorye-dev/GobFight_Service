package dev.yorye.gobfight_backend.auth.dto;

import dev.yorye.gobfight_backend.user.entity.User;
import lombok.Builder;
import java.util.Objects;

import java.time.LocalDateTime;

@Builder
public record TokenDto(
        Long id,
        User user,
        String refreshToken,
        LocalDateTime createdAt,
        LocalDateTime expiresAt,
        boolean revoked,
        String ipAddress,
        String userAgent) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TokenDto tokenDto = (TokenDto) o;
        return revoked == tokenDto.revoked &&
                this.id.equals(tokenDto.id) &&
                this.user.equals(tokenDto.user) &&
                this.refreshToken.equals(tokenDto.refreshToken) &&
                this.createdAt.equals(tokenDto.createdAt) &&
                this.expiresAt.equals(tokenDto.expiresAt) &&
                Objects.equals(ipAddress, tokenDto.ipAddress) &&
                Objects.equals(userAgent, tokenDto.userAgent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, refreshToken, createdAt, expiresAt, revoked, ipAddress, userAgent);
    }

}