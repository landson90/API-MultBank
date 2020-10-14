package com.example.app.multbanck.multbank.config.storage;

import com.example.app.multbanck.multbank.dto.PhotoClientStorageDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class StoragePhotoService implements StorageService {




    @Override
    public void storageClinetPhoto(PhotoClientStorageDTO photoClientStorageDTO) {


        try {
            // pegando o caminho onde a foto vai ser salva
            Path filePath = Path.of("C:\\Users\\l.barbosa.da.silva\\Desktop\\multbanck\\img_banco",
                    photoClientStorageDTO.getFileName());
            // FileCopyUtils.copy ==> fazendo um copia da img
            //  Files.newOutputStream ==> aqui é onde vamos salvar a foto
            FileCopyUtils.copy(photoClientStorageDTO.getInputStream(),
                    Files.newOutputStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
