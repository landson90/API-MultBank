package com.example.app.multbanck.multbank.repository;

import org.springframework.web.multipart.MultipartFile;

public interface PhotoStorageRepository {
    void stores(MultipartFile file);
}
