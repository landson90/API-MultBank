package com.example.app.multbanck.multbank.dto;

import org.springframework.web.multipart.MultipartFile;

public class ClientPhotoFormDTO {

    private MultipartFile multipartFile;
    private String descricao;

    public ClientPhotoFormDTO() {
    }

    public ClientPhotoFormDTO(MultipartFile multipartFile, String descricao) {
        this.multipartFile = multipartFile;
        this.descricao = descricao;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
