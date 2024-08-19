package com.springboot.springboot_restful_webservices.service.impl;

import com.springboot.springboot_restful_webservices.entity.User;
import com.springboot.springboot_restful_webservices.repository.UserRepository;
import com.springboot.springboot_restful_webservices.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceIMPL implements UserService {

    UserRepository userRepository;

    @Override
    public User createuser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User oldUser = userRepository.findById(user.getId()).get();
        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        oldUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(oldUser);
        return updatedUser;
    }

    @Override
    public void deleteUser(Long id) {
      userRepository.deleteById(id);
    }


}
