package com.example.app.multbanck.multbank.model;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "foto_cliente")
public class PhotoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_arquivo")
    private String fileName;

    @Column(name = "tipo_arquivo")
    private String contentType;

    @Column(name = "tamanho_arquivo")
    private Long fileSize;

    @OneToOne
    @JoinColumn(name = "cliente_id", unique = true)
    private ClientEntity clientEntity;

    public PhotoEntity() {
    }

    public PhotoEntity(Long id, String fileName, String contentType, Long fileSize, ClientEntity clientEntity) {
        this.id = id;
        this.fileName = fileName;
        this.contentType = contentType;
        this.fileSize = fileSize;
        this.clientEntity = clientEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
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
