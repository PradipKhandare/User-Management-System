package com.springboot.springboot_restful_webservices.repository;

import com.springboot.springboot_restful_webservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
        Optional<User> findByEmail(String email);
}
