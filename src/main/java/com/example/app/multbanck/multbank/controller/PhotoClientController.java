package com.example.app.multbanck.multbank.controller;

import com.example.app.multbanck.multbank.dto.PhotoClientDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Path;
import java.util.UUID;

@RestController
@RequestMapping("cliente/{clientId}/fotos")
public class PhotoClientController {


    @RequestMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void savePhotoClient(
            @PathVariable Long clientId, @Valid PhotoClientDTO photoClientDTO
            )
    {
        var nomeArquivo = UUID.randomUUID() +
                "_" + photoClientDTO.getFile().getOriginalFilename();
        var arquivoFoto = Path.of("C:\\Users\\l.barbosa.da.silva\\Desktop\\multbanck\\img_banco",
                nomeArquivo);


        try {
            photoClientDTO.getFile().transferTo(arquivoFoto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
