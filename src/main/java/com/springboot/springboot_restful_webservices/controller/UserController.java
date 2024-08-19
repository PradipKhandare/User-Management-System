package com.springboot.springboot_restful_webservices.controller;

import com.springboot.springboot_restful_webservices.entity.User;
import com.springboot.springboot_restful_webservices.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    //Create user rest-api

    //http://localhost:8080/api/users/create
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
      User user1 = userService.createuser(user);
      return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }


    //http://localhost:8080/api/users/1
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        System.out.println(user.getFirstName());
        System.out.println(user.getEmail());
        System.out.println(user.getLastName());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //http://localhost:8080/api/users/alluser
    @GetMapping("/alluser")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId, @RequestBody User user) {
        user.setId(userId);
       User updatedUser = userService.updateUser(user);
       return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>  deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }
}
