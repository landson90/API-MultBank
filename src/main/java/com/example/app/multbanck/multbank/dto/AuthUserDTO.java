package com.example.app.multbanck.multbank.dto;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class AuthUserDTO {

    private String email;
    private String password;

    public AuthUserDTO() {
    }

    public AuthUserDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsernamePasswordAuthenticationToken converteAuthLogin() {

        return new UsernamePasswordAuthenticationToken(email, password);
    }

}
