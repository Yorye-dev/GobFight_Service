package dev.yorye.gobfight_backend.auth.entity;


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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "token_refresh_token", nullable = false, length = 512)
    private String token;

    @Column(name = "token_created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "token_expires_at", nullable = false)
    private LocalDateTime expiresAt;

    @Column(name = "token_revoked", nullable = false)
    private boolean revoked;

    @Column(name = "token_ip_address", length = 45)
    private String ipAddress;

    @Column(name = "token_user_agent", length = 255)
    private String userAgent;

    public Token(User user, String refreshToken, LocalDateTime expiresAt, String ipAddress, String userAgent) {
        this.user = user;
        this.token = refreshToken;
        this.createdAt = LocalDateTime.now();
        this.expiresAt = expiresAt;
        this.revoked = false;
        this.ipAddress = ipAddress;
        this.userAgent = userAgent;
    }

    public Token(String token, LocalDateTime localDateTime, LocalDateTime localDateTime1, boolean active) {
    }
}