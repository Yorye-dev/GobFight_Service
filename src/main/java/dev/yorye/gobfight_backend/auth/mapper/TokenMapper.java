package dev.yorye.gobfight_backend.auth.mapper;

import dev.yorye.gobfight_backend.auth.dto.TokenDto;
import dev.yorye.gobfight_backend.auth.entity.Token;

public class TokenMapper {

    public static Token toToken(TokenDto tokenDto){
        return new Token (
                tokenDto.id(),
                tokenDto.user(),
                tokenDto.token(),
                tokenDto.createdAt(),
                tokenDto.expiresAt(),
                tokenDto.revoked(),
                tokenDto.type()
        );
    }

    public static TokenDto toDto(Token token) {
        return TokenDto.builder()
                .id(token.getId())
                .user(token.getUser())
                .token(token.getToken())
                .createdAt(token.getCreatedAt())
                .expiresAt(token.getExpiresAt())
                .revoked(token.isRevoked())
                .type(token.getType())
                .build();
    }
}
