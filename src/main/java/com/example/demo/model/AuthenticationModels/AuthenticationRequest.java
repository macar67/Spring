package com.example.demo.model.AuthenticationModels;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthenticationRequest{
    private String username;
    private String password;

}