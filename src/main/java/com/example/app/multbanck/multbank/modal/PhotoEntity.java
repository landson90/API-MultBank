package com.example.app.multbanck.multbank.modal;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "arquivos")
public class PhotoEntity {

    private Long id;
    private MultipartFile arquivo;

    @OneToOne
    @JoinColumn(name = "cliente_id", unique = true)
    private ClientEntity clientEntity;

    public PhotoEntity() { }

    public PhotoEntity(Long id, MultipartFile arquivo, ClientEntity clientEntity) {
        this.id = id;
        this.arquivo = arquivo;
        this.clientEntity = clientEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MultipartFile getArquivo() {
        return arquivo;
    }

    public void setArquivo(MultipartFile arquivo) {
        this.arquivo = arquivo;
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
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "PhotoEntity{" +
                "id=" + id +
                ", arquivo=" + arquivo +
                ", clientEntity=" + clientEntity +
                '}';
    }
}
