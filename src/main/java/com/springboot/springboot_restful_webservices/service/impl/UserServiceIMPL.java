package com.springboot.springboot_restful_webservices.service.impl;

import com.springboot.springboot_restful_webservices.DTO.UserDto;
import com.springboot.springboot_restful_webservices.entity.User;
import com.springboot.springboot_restful_webservices.exceptions.EmailAlreadyExistException;
import com.springboot.springboot_restful_webservices.exceptions.ResourceNotFoundException;
import com.springboot.springboot_restful_webservices.mapper.UserMapper;
import com.springboot.springboot_restful_webservices.repository.UserRepository;
import com.springboot.springboot_restful_webservices.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceIMPL implements UserService {

    UserRepository userRepository;
    ModelMapper modelMapper;

    @Override
    public UserDto createuser(UserDto userDto) {

        //convert userDto dto into userDto JPA entity

       //User user = UserMapper.mapToUser(userDto);

        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
        if (optionalUser.isPresent()) {
            throw new EmailAlreadyExistException("Email already exist for this user");
        }

        User user = modelMapper.map(userDto, User.class);
        User savedUser = userRepository.save(user);

        //convert usr jpa entity to user dto

       // UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
        UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);
        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long id) {
        User optionalUser = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );
        //User user = optionalUser.get();
//        return UserMapper.mapToUserDto(user);
      //  return modelMapper.map(user, UserDto.class);
        return modelMapper.map(optionalUser, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
//        return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());

        return users.stream().map((user) -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User oldUser = userRepository.findById(user.getId()).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", user.getId())
        );
        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        oldUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(oldUser);
//        return UserMapper.mapToUserDto(updatedUser);

        return modelMapper.map(updatedUser, UserDto.class);
    }

    @Override
    public void deleteUser(Long id) {
        User oldUser = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );
      userRepository.deleteById(id);
    }


}
