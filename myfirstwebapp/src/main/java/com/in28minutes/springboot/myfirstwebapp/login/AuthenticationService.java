package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authenticate(String username, String password) {
        boolean isValidUsername = username.equalsIgnoreCase("Caio-HBS");
        boolean isValidPassword = password.equals("123456");

        return isValidUsername && isValidPassword;
    }

}
