package dev.yorye.gobfight_backend.user.service;

import ch.qos.logback.core.boolex.Matcher;
import dev.yorye.gobfight_backend.user.dto.UserDto;
import dev.yorye.gobfight_backend.user.entity.User;
import dev.yorye.gobfight_backend.user.mapper.UserMapper;
import dev.yorye.gobfight_backend.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void createNewUser(UserDto userDto) {
        var user = UserMapper.toUser(userDto);
        user.setCreatedAt(LocalDateTime.now());
        saveUser(user);
    }

    @Override
    public UserDto getUserById(Long id) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return List.of();
    }

    @Override
    public void updateUser(Long id, UserDto userDto) {

    }

    @Override
    public void deleteUser(Long id) {

    }
    @Override
    public UserDto validateUser(String nickname, String password) {
        UserDto userDto = getUsersByNickname(nickname);
        if (!isPasswordCorrect(password, userDto.hashedPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return userDto;
    }

    @Override
    public UserDto getUsersByNickname(String nickname) {
        UserDto userDto =  UserMapper.toUserDto(userRepository.findByNickname(nickname)
                .orElseThrow(() -> new RuntimeException("Invalid credentials")));
        return userDto;
    }

    private void saveUser(User user) {
        user.setUpdatedAt(LocalDateTime.now());
        userRepository.save(user);
    }

    private boolean isPasswordCorrect(String password, String hashedPassword){
        return passwordEncoder.matches(password, hashedPassword);
    }
}
