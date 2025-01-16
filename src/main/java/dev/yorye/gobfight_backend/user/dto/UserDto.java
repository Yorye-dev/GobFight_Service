package dev.yorye.gobfight_backend.user.dto;

public record UserDto(
        Long Id,
        String nickname,
        String email,
        String hashedPassword) {

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        UserDto userDto = (UserDto) obj;
        return nickname.equals(userDto.nickname) && email.equals(userDto.email) && hashedPassword.equals(userDto.hashedPassword);
    }

}

