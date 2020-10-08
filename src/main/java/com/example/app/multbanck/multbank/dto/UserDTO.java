package com.example.app.multbanck.multbank.dto;

import com.example.app.multbanck.multbank.model.ProfileEntity;
import com.example.app.multbanck.multbank.model.UsuarioEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    private Integer id;
    private String nome;
    private String email;
    private String password;
    private List<ProfileEntity> perfil = new ArrayList<>();

    public UserDTO() {
    }

    public UserDTO(UsuarioEntity userEntity) {
        this.id = userEntity.getId();
        this.nome = userEntity.getNome();
        this.email = userEntity.getEmail();
        this.password = userEntity.getPassword();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    public List<ProfileEntity> getPerfil() {
        return perfil;
    }

    public void setPerfil(List<ProfileEntity> perfil) {
        this.perfil = perfil;
    }
}
