package dev.yorye.gobfight_backend.auth.repository;

import dev.yorye.gobfight_backend.auth.entity.Token;
import dev.yorye.gobfight_backend.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

        List<Token> findByUser(User user);

        Optional<Token> findByRefreshToken(String refreshToken);

        void deleteByRefreshToken(String refreshToken);
}