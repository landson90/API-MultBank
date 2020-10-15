package com.example.app.multbanck.multbank.config.storage;

import com.example.app.multbanck.multbank.dto.PhotoClientAwsDTO;
import com.example.app.multbanck.multbank.dto.PhotoClientStorageDTO;

import java.io.InputStream;

public interface StorageService {

    void storageClinetPhoto(PhotoClientStorageDTO photoClientStorageDTO);
    void deleteClientPhoto(String  fileName);
    PhotoClientAwsDTO show(String fileName);

}
