package com.example.app.multbanck.multbank.dto;

import com.example.app.multbanck.multbank.modal.ClientEntity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ClientDTO {

    private Long id;
    @NotNull
    @NotEmpty(message = "O Campo nome é obrigatório .")
    private String name;
    @NotNull
    @NotEmpty(message = "O Campo email é obrigatório .")
    private String email;
    @NotNull
    @NotEmpty(message = "O Campo password é obrigatório .")
    private String password;

    public ClientDTO() { }

    public ClientDTO(ClientEntity clientEntity) {
        this.id = clientEntity.getId();
        this.name = clientEntity.getName();
        this.email = clientEntity.getEmail();
        this.password = clientEntity.getPassword();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
