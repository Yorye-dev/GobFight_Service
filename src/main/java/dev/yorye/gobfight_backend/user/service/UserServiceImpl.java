package dev.yorye.gobfight_backend.user.service;

import dev.yorye.gobfight_backend.user.dto.UserDto;
import dev.yorye.gobfight_backend.user.entity.User;
import dev.yorye.gobfight_backend.user.mapper.UserMapper;
import dev.yorye.gobfight_backend.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    //@Transactional
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

    private void saveUser(User user) {
        user.setUpdatedAt(LocalDateTime.now());
        userRepository.save(user);
    }
}
