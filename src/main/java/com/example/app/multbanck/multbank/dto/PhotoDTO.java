package com.example.app.multbanck.multbank.dto;

import com.example.app.multbanck.multbank.model.ClientEntity;
import com.example.app.multbanck.multbank.model.PhotoEntity;
import org.springframework.web.multipart.MultipartFile;

public class PhotoDTO {

    private Long id;
    private MultipartFile arquivo;
    private ClientEntity clientEntity;


    public PhotoDTO() {
    }

    public PhotoDTO(PhotoEntity photoEntity) {
        this.id = photoEntity.getId();
        this.arquivo = photoEntity.getArquivo();
        this.clientEntity = photoEntity.getClientEntity();
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
}
