package dev.yorye.gobfight_backend.auth.service;

import dev.yorye.gobfight_backend.auth.entity.Token;
import dev.yorye.gobfight_backend.auth.repository.TokenRepository;
import dev.yorye.gobfight_backend.user.dto.UserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Jwts;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@NoArgsConstructor
@Service
public class JwtServiceImpl implements JwtService {

    TokenRepository tokenRepository;

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long expiration;

    @Override
    public String generateToken(final UserDto userDto) {
        return buildToken(userDto);
    }

    @Override
    public boolean isValidateToken(final String token, UserDto user) {

        String extractedNicknameFromToken = extractNicknameFromToken(token);
        return extractedNicknameFromToken.equals(user.nickname());
    }

    @Override
    public String generateRefreshToken(UserDto user) {
        return buildRefreshToken(user);
    }

    @Override
    public String generateRefreshToken(final String token) {
        // Implementar lógica para generar un nuevo token
        return "";
    }

    @Override
    public UserDto getUserDtoFromToken(final String token) {
        // Implementar lógica para extraer información del usuario desde el token
        return null;
    }

    @Override
    public boolean isTokenExpired(String token) {
        return false;
    }

    @Override
    public void deleteToken(String token) {

    }

    private String buildToken(final UserDto userDto) {
        return Jwts.builder()
                .setSubject(userDto.nickname())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSecretKey())
                .compact();
    }

    private String buildRefreshToken(final UserDto userDto) {
        return buildToken(userDto);
    }

    private SecretKey getSecretKey() {
        byte[] secretBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(secretBytes);
    }

    private String extractTokenFromHeader(final String header) {
        // Implementar lógica para extraer el token del header
        return "";
    }

    private String extractNicknameFromToken(final String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(secretKey.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            return claims.get("nickname", String.class);
        } catch (Exception e) {

            throw new RuntimeException("Error al procesar el token: " + e.getMessage());
        }
    }

    private void saveToken(final Token token) {
        tokenRepository.save(token);
    }
}
