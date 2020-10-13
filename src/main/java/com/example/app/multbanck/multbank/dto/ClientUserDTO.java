package com.example.app.multbanck.multbank.dto;

import com.example.app.multbanck.multbank.config.validator.customized.ClientInsert;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@ClientInsert
public class ClientUserDTO {

    @NotEmpty(message = "O nome é obrigatório .")
    private String nome;

    @NotEmpty(message = "O Email é obrigatório .")
    @Email
    private String email;

    @NotNull
    @NotEmpty(message = "O Campo password é obrigatório .")
    @Length(min = 6, max = 11, message = "Deve de 6 á 11 dígitos .")
    private String password;

    @NotNull
    @NotEmpty(message = "O Campo cpf é obrigatório .")
    @Length(min = 3, max = 11, message = "Deve conter 11 dígitos .")
    private String cpf;

    @NotNull(message = "O Campo data de nascimento é obrigatório .")
    private LocalDate dateOfBirth;

    private Long usuarioId;

    public ClientUserDTO() {
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
        this.password = password;
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

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
