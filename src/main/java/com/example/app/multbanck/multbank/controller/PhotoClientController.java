package com.example.app.multbanck.multbank.controller;

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
public class PhotoClientController {

    private PhotoClientService photoClientService;

    @Autowired
    public PhotoClientController(PhotoClientService photoClientService) {
        this.photoClientService = photoClientService;
    }

    @RequestMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<PhotoClientDTO> savePhotoClient(@PathVariable Long clientId, @Valid PhotoDTO photoDTO ) {
        return this.photoClientService.store(clientId, photoDTO);
    }
}
