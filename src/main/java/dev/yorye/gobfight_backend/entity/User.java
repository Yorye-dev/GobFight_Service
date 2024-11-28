package dev.yorye.gobfight_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",unique = true, nullable = false)
    private Long id;

    @Column(name = "user_name",unique = true, nullable = false)
    private String username;

    @Column(name = "user_password", nullable = false)
    private String password;
}
