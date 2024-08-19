package com.springboot.springboot_restful_webservices.repository;

import com.springboot.springboot_restful_webservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
