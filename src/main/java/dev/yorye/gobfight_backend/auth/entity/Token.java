package dev.yorye.gobfight_backend.auth.entity;


import dev.yorye.gobfight_backend.auth.constants.TokenType;
import dev.yorye.gobfight_backend.user.entity.User;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "token")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "token_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "token_string", nullable = false, length = 512)
    private String token;

    @Column(name = "token_created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "token_expires_at", nullable = false)
    private LocalDateTime expiresAt;

    @Column(name = "token_revoked", nullable = false)
    private boolean revoked;

    @Column(name = "token_type", nullable = false)
    private TokenType type;

    public Token(User user, String refreshToken, LocalDateTime expiresAt, TokenType type) {
        this.user = user;
        this.token = refreshToken;
        this.createdAt = LocalDateTime.now();
        this.expiresAt = expiresAt;
        this.revoked = false;
        this.type = type;
    }
}