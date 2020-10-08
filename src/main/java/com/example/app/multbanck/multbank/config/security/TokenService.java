package com.example.app.multbanck.multbank.config.security;

import com.example.app.multbanck.multbank.model.UsuarioEntity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    // pegando a variável de configuração do arquivo *application.properties
    @Value("${forum.jwt.secret}")
    private String secret;

    // pegando a variável de configuração do arquivo *application.properties
    @Value("${forum.jwt.expiration}")
    private String expiration;


    public String storeToken(Authentication autentication) {
        UsuarioEntity usuario = (UsuarioEntity) autentication.getPrincipal();
        Date hoje = new Date();
        Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));


        return Jwts.builder()
                .setIssuer("MultBank")
                .setSubject(usuario.getId().toString())
                .setIssuedAt(hoje)
                .setExpiration(dataExpiracao)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

}
