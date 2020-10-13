package com.example.app.multbanck.multbank.dto;

import org.springframework.web.multipart.MultipartFile;

public class PhotoDTO {
    private MultipartFile multipartFile;

    public PhotoDTO() {
    }

    public PhotoDTO(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }
}
