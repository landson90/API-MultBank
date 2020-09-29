package com.example.app.multbanck.multbank.dto;

import com.example.app.multbanck.multbank.modal.ClientEntity;

public class ClientDTO {

    private Long id;
    private String name;
    private String email;
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
