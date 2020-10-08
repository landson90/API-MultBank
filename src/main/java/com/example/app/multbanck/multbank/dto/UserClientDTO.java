package com.example.app.multbanck.multbank.dto;

import com.example.app.multbanck.multbank.model.ClientEntity;
import com.example.app.multbanck.multbank.model.UsuarioEntity;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class UserClientDTO {

    private Long id;

    @NotNull
    @Email
    @NotEmpty(message = "O Campo nome é obrigatório .")
    private String email;

    @NotNull
    @NotEmpty(message = "O Campo nome é obrigatório .")
    @Length(min = 6, max = 36, message = "O *password deve conter no mínimo 6 no máximo 36 dígitos.")
    private String password;

    @NotNull
    @NotEmpty(message = "O Campo nome é obrigatório .")
    @Length(min = 3, message = "O campo *nome deve conter no mínimo 3")
    private String name;

    @NotNull
    @NotEmpty(message = "O Campo cpf é obrigatório .")
    @Length(min = 3, max = 11, message = "Deve conter 11 dígitos .")
    private String cpf;

    @NotNull(message = "O Campo data de nascimento é obrigatório .")
    private LocalDate dateOfBirth;

    public UserClientDTO() {
    }

    public UserClientDTO(
                         Long id,
                         String email,
                         String password,
                         String name,
                         String cpf,
                         LocalDate dateOfBirth) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.cpf = cpf;
        this.dateOfBirth = dateOfBirth;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public ClientEntity convertUserClientDTOToClientEntity(UserClientDTO userClientDTO) {
        return new ClientEntity(
                userClientDTO.getId(),
                userClientDTO.getName(),
                userClientDTO.getDateOfBirth(),
                userClientDTO.getCpf()
        );
    }
}
