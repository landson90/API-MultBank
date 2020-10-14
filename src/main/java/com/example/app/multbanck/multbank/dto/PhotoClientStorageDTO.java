package com.example.app.multbanck.multbank.dto;

import java.io.InputStream;

public class PhotoClientStorageDTO {

    private String fileName;
    private InputStream inputStream;

    public PhotoClientStorageDTO() {
    }

    public PhotoClientStorageDTO(String fileName, InputStream inputStream) {
        this.fileName = fileName;
        this.inputStream = inputStream;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}
