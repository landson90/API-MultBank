package com.example.app.multbanck.multbank.dto;

import com.example.app.multbanck.multbank.modal.ClientEntity;
import javax.validation.constraints.NotNull;

public class ClientDTO {

    private Long id;
    @NotNull(message = "Campo nome é obrigatorio .")
    private String name;
    @NotNull(message = "Campo email é obrigatorio .")
    private String email;
    @NotNull(message = "Campo password é obrigatorio .")
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
