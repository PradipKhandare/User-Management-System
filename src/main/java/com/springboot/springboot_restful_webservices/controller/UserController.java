package com.springboot.springboot_restful_webservices.controller;

import com.springboot.springboot_restful_webservices.DTO.UserDto;
import com.springboot.springboot_restful_webservices.entity.User;
import com.springboot.springboot_restful_webservices.exceptions.ErrorDetails;
import com.springboot.springboot_restful_webservices.exceptions.ResourceNotFoundException;
import com.springboot.springboot_restful_webservices.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    //Create user rest-api

    //http://localhost:8080/api/users/create\
    @Valid
    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
        UserDto user1 = userService.createuser(user);
      return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/users/1
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id) {
        UserDto user = userService.getUserById(id);
        System.out.println(user.getFirstName());
        System.out.println(user.getEmail());
        System.out.println(user.getLastName());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //http://localhost:8080/api/users/alluser
    @GetMapping("/alluser")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Valid
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId, @RequestBody UserDto user) {
        user.setId(userId);
       UserDto updatedUser = userService.updateUser(user);
       return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>  deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException, WebRequest webRequest){
//            ErrorDetails errorDetails = new ErrorDetails(
//                    LocalDateTime.now(),
//                    resourceNotFoundException.getMessage(),
//                    webRequest.getDescription(false),
//                    "user not found"
//            );
//            return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//    }
}
