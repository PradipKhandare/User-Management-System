package com.springboot.springboot_restful_webservices.service;

import com.springboot.springboot_restful_webservices.entity.User;

import java.util.List;

public interface UserService {

    User createuser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(Long id);
}
