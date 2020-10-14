package com.example.app.multbanck.multbank.dto;

import org.springframework.web.multipart.MultipartFile;

public class ClientPhotoInputDTO {

    private MultipartFile file;

    public ClientPhotoInputDTO() {
    }

    public ClientPhotoInputDTO(MultipartFile file) {
        this.file = file;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
