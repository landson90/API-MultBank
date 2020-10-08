package com.example.app.multbanck.multbank.config.security;

import com.example.app.multbanck.multbank.model.UsuarioEntity;
import com.example.app.multbanck.multbank.repository.UserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationAuthenticationTokenFilter  extends OncePerRequestFilter {

    private TokenService tokenService;
    private UserRepository userRepository;

    public AuthenticationAuthenticationTokenFilter(TokenService tokenService, UserRepository userRepository) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String token = recuperaToken(httpServletRequest);
        boolean tokenIsValid = tokenService.isValidToken(token);
        if(tokenIsValid) {
            autenticarUsuarioLogado(token);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }
    private String recuperaToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if(token == null || token.isEmpty() || token.startsWith("Berear ")) {
            return null;
        }

        return token.substring(7, token.length());
    }

    private void autenticarUsuarioLogado(String token) {
        Long idUsuarioLogado = tokenService.getUsuarioLogado(token);
        UsuarioEntity usuario = userRepository.findById(idUsuarioLogado).get();
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario,
                null,
                usuario.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }


}
