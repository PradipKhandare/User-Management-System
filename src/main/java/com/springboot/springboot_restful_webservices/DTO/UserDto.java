package com.springboot.springboot_restful_webservices.DTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotEmpty(message = "should not be empty")
    private Long id;

    @NotEmpty(message = "should not be empty")
    private String firstName;

    @NotEmpty(message = "should not be empty")
    private String lastName;

    @NotEmpty(message = "should not be empty")
    @Email
    private String email;

}
