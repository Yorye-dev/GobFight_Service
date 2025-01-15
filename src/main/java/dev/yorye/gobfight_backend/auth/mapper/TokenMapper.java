package dev.yorye.gobfight_backend.auth.mapper;

import dev.yorye.gobfight_backend.auth.dto.TokenDto;
import dev.yorye.gobfight_backend.auth.entity.Token;

public class TokenMapper {

    public static Token toToken(TokenDto tokenDto){
        return new Token(
                tokenDto.token(),
                tokenDto.createdAt(),
                tokenDto.expiresAt(),
                tokenDto.active()
        );
    }
}
