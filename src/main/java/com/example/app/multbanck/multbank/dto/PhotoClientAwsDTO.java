package com.example.app.multbanck.multbank.dto;

import java.io.InputStream;

public class PhotoClientAwsDTO {
    private InputStream inputStream;
    private String url;

    public PhotoClientAwsDTO() {
    }

    public PhotoClientAwsDTO(InputStream inputStream, String url) {
        this.inputStream = inputStream;
        this.url = url;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
