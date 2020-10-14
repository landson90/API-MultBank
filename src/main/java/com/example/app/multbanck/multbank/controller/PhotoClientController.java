package com.example.app.multbanck.multbank.controller;

import com.example.app.multbanck.multbank.dto.ClientPhotoInputDTO;
import com.example.app.multbanck.multbank.service.PhotoClientService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente/{clientID}/fotos")
public class PhotoClientController {

    private PhotoClientService photoClientService;

    public PhotoClientController(PhotoClientService photoClientService) {
        this.photoClientService = photoClientService;
    }

    public  void store(@PathVariable Long clientID, ClientPhotoInputDTO clientPhotoInputDTO) {
        this.photoClientService.store(clientID, clientPhotoInputDTO);
    }
}
