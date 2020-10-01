package com.example.app.multbanck.multbank.dto;

import com.example.app.multbanck.multbank.config.validator.customized.ClientUpdate;
import com.example.app.multbanck.multbank.modal.ClientEntity;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@ClientUpdate
public class ClientUpdateDTO {

    private Long id;

    @NotNull
    @NotEmpty(message = "O Campo nome é obrigatório .")
    private String name;

    @NotNull
    @NotEmpty(message = "O Campo cpf é obrigatório .")
    @Length(min = 3, max = 11, message = "Deve conter 11 dígitos .")
    private String cpf;

    @NotNull(message = "O Campo data de nascimento é obrigatório .")
    private LocalDate dateOfBirth;

    public ClientUpdateDTO() { }

    public ClientUpdateDTO(ClientEntity clientEntity) {
        this.id          = clientEntity.getId();
        this.name        = clientEntity.getName();
        this.dateOfBirth = clientEntity.getDateOfBirth();
        this.cpf         = clientEntity.getCpf();
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
