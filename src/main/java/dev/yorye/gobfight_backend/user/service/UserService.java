package dev.yorye.gobfight_backend.user.service;

import dev.yorye.gobfight_backend.user.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto getUserById(Long id);
    List<UserDto> getAllUsers();
    void createNewUser(UserDto user);
    void updateUser(Long id, UserDto userDto);
    void deleteUser(Long id);
}
