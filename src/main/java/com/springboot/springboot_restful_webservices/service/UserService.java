package com.springboot.springboot_restful_webservices.service;

import com.springboot.springboot_restful_webservices.DTO.UserDto;
import com.springboot.springboot_restful_webservices.entity.User;

import java.util.List;

public interface UserService {

    UserDto createuser(UserDto user);

    UserDto getUserById(Long id);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto user);

    void deleteUser(Long id);
}
