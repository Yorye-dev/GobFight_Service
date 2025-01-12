package dev.yorye.gobfight_backend.user.entity;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id") // Mapea el campo `user_id`
    private Long id;

    @Column(name = "user_nickname", nullable = false)
    private String nickname;

    @Column(name = "user_password", nullable = false, length = 255)
    private String password;

    @Column(name = "user_created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "user_updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "user_email", nullable = false, length = 255)
    private String email;

    public User(String nickname, String email, String hashedPassword) {
        this.nickname = nickname;
        this.email = email;
        this.password = hashedPassword;
    }
}
