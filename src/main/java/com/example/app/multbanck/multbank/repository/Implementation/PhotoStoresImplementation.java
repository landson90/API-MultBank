package com.example.app.multbanck.multbank.repository.Implementation;

import com.example.app.multbanck.multbank.repository.PhotoStorageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.UUID;

@Service
public class PhotoStoresImplementation implements PhotoStorageRepository {

    @Override
    public void stores(MultipartFile file) {
            var nomeArquivo = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            var arquivoFoto = Path.of("C:/Users/l.barbosa.da.silva/Desktop/multbanck/img_banco", nomeArquivo);

            try {
                file.transferTo(arquivoFoto);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }
}
