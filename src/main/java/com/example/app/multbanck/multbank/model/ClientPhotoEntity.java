package com.example.app.multbanck.multbank.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "foto_cliente")
public class ClientPhotoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cliente_id")
    private ClientEntity clientEntity;
    private String descricao;
    private String contentType;
    @Column(name = "nome_do_arquivo")
    private String nomeDoAraquivo;
    private int tamanho;

    public ClientPhotoEntity() {
    }

    public ClientPhotoEntity(Long id,
                             ClientEntity clientEntity,
                             String descricao,
                             String contentType,
                             String nomeDoAraquivo,
                             int tamanho) {
        this.id = id;
        this.clientEntity = clientEntity;
        this.descricao = descricao;
        this.contentType = contentType;
        this.nomeDoAraquivo = nomeDoAraquivo;
        this.tamanho = tamanho;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getNomeDoAraquivo() {
        return nomeDoAraquivo;
    }

    public void setNomeDoAraquivo(String nomeDoAraquivo) {
        this.nomeDoAraquivo = nomeDoAraquivo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientPhotoEntity that = (ClientPhotoEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
