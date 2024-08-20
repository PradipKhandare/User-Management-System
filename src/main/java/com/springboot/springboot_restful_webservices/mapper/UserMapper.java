package com.springboot.springboot_restful_webservices.mapper;

import com.springboot.springboot_restful_webservices.DTO.UserDto;
import com.springboot.springboot_restful_webservices.entity.User;

public class UserMapper {


    //convert user jpa entity into user dto
    public static UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto(
                user.getId(), user.getFirstName(), user.getLastName(), user.getEmail()
        );

        return userDto;
    }

    //convert user dto into user jpa entity
    public static User mapToUser(UserDto userDto) {
        User user = new User(
                userDto.getId(), userDto.getFirstName(), userDto.getLastName(), userDto.getEmail()
        );
        return user;
    }
}
