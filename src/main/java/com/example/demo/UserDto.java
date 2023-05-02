package com.example.demo;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;

public class UserDto {

    @Id
    private String id;

    @NotBlank
    private String username;

    @NotBlank
    private String password;



    public UserDto(String id,String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public String getId() {
        return id;
    }

    public String getPassword(){
        return password;
    }

    // getter, setter, toString
}
