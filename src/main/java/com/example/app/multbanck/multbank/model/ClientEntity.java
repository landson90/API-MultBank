package com.example.app.multbanck.multbank.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "clientes",
        uniqueConstraints={@UniqueConstraint(columnNames="cpf")})
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "data_nascimento")
    private LocalDate dateOfBirth;

    @Column(unique = true)
    private String cpf;

<<<<<<< HEAD
    @OneToOne
    @JoinColumn(name = "usuario_id", unique = true)
    private UsuarioEntity usuarioEntity;

    public ClientEntity() {
    }

    public ClientEntity(Long id, String name, LocalDate dateOfBirth, String cpf, UsuarioEntity usuarioEntity) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.cpf = cpf;
        this.usuarioEntity = usuarioEntity;
=======
    @Column(name = "usuario_id")
    private Long userId;

    public ClientEntity() { }

    public ClientEntity(Long id, String name, LocalDate dateOfBirth, String cpf, Long userId) {
        this.id             = id;
        this.name           = name;
        this.dateOfBirth    = dateOfBirth;
        this.cpf            = cpf;
        this.userId         = userId;
>>>>>>> 48e87aeb49b151cc896d5b2f6bd2f6214d8ee945
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

<<<<<<< HEAD
    public UsuarioEntity getUsuarioEntity() {
        return usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
=======
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
>>>>>>> 48e87aeb49b151cc896d5b2f6bd2f6214d8ee945
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientEntity that = (ClientEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
