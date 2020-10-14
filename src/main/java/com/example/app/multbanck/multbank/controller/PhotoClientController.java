package com.example.app.multbanck.multbank.controller;

<<<<<<< HEAD
import com.example.app.multbanck.multbank.dto.PhotoClientDTO;
import com.example.app.multbanck.multbank.dto.PhotoDTO;
import com.example.app.multbanck.multbank.service.PhotoClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Path;
import java.util.UUID;

@RestController
@RequestMapping("cliente/{clientId}/fotos")
=======
import com.example.app.multbanck.multbank.dto.ClientPhotoInputDTO;
import com.example.app.multbanck.multbank.service.PhotoClientService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/cliente/{clientID}/fotos")
>>>>>>> 1.8-cliente-usuario-conta
public class PhotoClientController {

    private PhotoClientService photoClientService;

<<<<<<< HEAD
    @Autowired
=======
>>>>>>> 1.8-cliente-usuario-conta
    public PhotoClientController(PhotoClientService photoClientService) {
        this.photoClientService = photoClientService;
    }

<<<<<<< HEAD
    @RequestMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<PhotoClientDTO> savePhotoClient(@PathVariable Long clientId, @Valid PhotoDTO photoDTO ) {
        return this.photoClientService.store(clientId, photoDTO);
=======
    @PostMapping
    public  void store(@PathVariable Long clientID, ClientPhotoInputDTO clientPhotoInputDTO) throws IOException {
        this.photoClientService.store(clientID, clientPhotoInputDTO);
>>>>>>> 1.8-cliente-usuario-conta
    }
}
