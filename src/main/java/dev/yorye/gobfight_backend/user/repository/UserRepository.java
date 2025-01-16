package dev.yorye.gobfight_backend.user.repository;

import dev.yorye.gobfight_backend.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User>  findByNickname(String nombre);

    Optional<User> findByEmail(String email);

    long countByNickname(String nombre);

    void deleteByNickname(String nombre);

    void getUserByNickname(String nickname);
}