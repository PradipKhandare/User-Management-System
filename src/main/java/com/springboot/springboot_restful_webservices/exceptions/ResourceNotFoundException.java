package com.springboot.springboot_restful_webservices.exceptions;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException
{
    private String resourceName;
    private String fieldName;
    private Long fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, Long fieldValue){
        super(String.format("Resource %s not found for field %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
