package com.example.app.multbanck.multbank.dto;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

public class PhotoClientDTO {

    @NotNull(message = "Campo foto é obrigatorio .")
    private MultipartFile file;
    private String description;

    public PhotoClientDTO() {
    }

    public PhotoClientDTO( MultipartFile file, String description) {

        this.file = file;
        this.description = description;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
