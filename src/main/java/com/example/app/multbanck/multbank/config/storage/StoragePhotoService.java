package com.example.app.multbanck.multbank.config.storage;

import com.example.app.multbanck.multbank.dto.PhotoClientStorageDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class StoragePhotoService implements StorageService {

    @Override
    public void storageClinetPhoto(PhotoClientStorageDTO photoClientStorageDTO) {

        try {

            Path filePath = Path.of("C:\\Users\\l.barbosa.da.silva\\Desktop\\multbanck\\img_banco",
                    photoClientStorageDTO.getFileName());

            FileCopyUtils.copy(photoClientStorageDTO.getInputStream(),
                    Files.newOutputStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
