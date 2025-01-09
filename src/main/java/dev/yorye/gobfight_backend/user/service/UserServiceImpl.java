package dev.yorye.gobfight_backend.user.service;

import dev.yorye.gobfight_backend.user.dto.UserDto;

import java.util.List;

public class UserServiceImpl implements UserService{
    @Override
    public UserDto getUserById(Long id) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return List.of();
    }

    @Override
    public void createNewUser(UserDto user) {

    }

    @Override
    public void updateUser(Long id, UserDto userDto) {

    }

    @Override
    public void deleteUser(Long id) {

    }
}
