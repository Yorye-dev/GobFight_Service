package dev.yorye.gobfight_backend.auth.service;

import dev.yorye.gobfight_backend.user.dto.UserDto;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.validation.annotation.Validated;
import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtServiseImpl implements JwtServise {
    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private String expiration;

    @Override
    public String generateToken(final UserDto userDto) {
        return buildToken(userDto);
    }

    @Override
    public boolean vaidateToken(final String token) {
        return false;
    }

    @Override
    public String refreshToken(final String token) {
        return "";
    }

    @Override
    public UserDto getUserFromToken(final String token) {
        return null;
    }

    private String buildToken(final UserDto userDto) {
        return Jwts.builder()
                .setSubject(userDto.nickname())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getScretKey())
                .compact();
    }

    private SecretKey getScretKey() {
        byte[] secretBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(secretBytes);
    }
}
