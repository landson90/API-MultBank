package com.example.app.multbanck.multbank.controller;

import com.example.app.multbanck.multbank.config.security.TokenService;
import com.example.app.multbanck.multbank.dto.AuthUserDTO;
import com.example.app.multbanck.multbank.dto.TokenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;



    @PostMapping
    public ResponseEntity<TokenDTO> login(@RequestBody @Valid AuthUserDTO dataFormLogin) {
        UsernamePasswordAuthenticationToken autenticacaoUsuario = dataFormLogin.converteAuthLogin();

        try {
            Authentication authentication = this.authenticationManager.authenticate(autenticacaoUsuario);

            String token = this.tokenService.storeToken(authentication);

            return ResponseEntity.ok().body(new TokenDTO(token, "Bearer"));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }

    }



}
