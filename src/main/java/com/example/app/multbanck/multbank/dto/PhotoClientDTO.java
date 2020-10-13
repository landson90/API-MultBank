package com.example.app.multbanck.multbank.dto;

import com.example.app.multbanck.multbank.model.ClientEntity;
import com.example.app.multbanck.multbank.model.PhotoEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

public class PhotoClientDTO {

    private Long id;
    private String fileName;
    private String contentType;
    private Long fileSize;
    private ClientEntity clientEntity;

    public PhotoClientDTO() {
    }

    public PhotoClientDTO(PhotoEntity photoEntity) {
        this.id = photoEntity.getId();
        this.fileName = photoEntity.getFileName();
        this.contentType = photoEntity.getContentType();
        this.fileSize = photoEntity.getFileSize();
        this.clientEntity = photoEntity.getClientEntity();
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
}