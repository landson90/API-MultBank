package com.example.app.multbanck.multbank.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.UUID;


@RestController
@RequestMapping("clientes/{clienteId}/foto")
public class ClientPhotoController {

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void store(
            @PathVariable Long clienteId,
            @RequestParam MultipartFile arquivo) {
        var nomeArquivo = UUID.randomUUID().toString() +"_"+ arquivo.getOriginalFilename();
        var arquivoFoto = Path.of("C:/Users/l.barbosa.da.silva/Desktop/multbanck/img_banco", nomeArquivo);

        try{
            arquivo.transferTo(arquivoFoto);
        }catch (Exception e) {
            throw  new RuntimeException(e);
        }

    }
}
