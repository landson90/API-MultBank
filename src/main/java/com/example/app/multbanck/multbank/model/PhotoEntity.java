package com.example.app.multbanck.multbank.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "foto")
public class PhotoEntity {

    private Long id;
    @OneToOne
    @JoinColumn(name = "cliente_id")
    private ClientEntity clientEntity;
    private String nomeArquivo;
    private String Descricao;
    private String contentType;
    private Long tamanho;

    public PhotoEntity() { }

    public PhotoEntity(Long id,
                       ClientEntity clientEntity,
                       String nomeArquivo,
                       String descricao,
                       String contentType,
                       Long tamanho) {
        this.id = id;
        this.clientEntity = clientEntity;
        this.nomeArquivo = nomeArquivo;
        Descricao = descricao;
        this.contentType = contentType;
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

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Long getTamanho() {
        return tamanho;
    }

    public void setTamanho(Long tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhotoEntity that = (PhotoEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
