package com.example.app.multbanck.multbank.controller;


import com.example.app.multbanck.multbank.dto.ClientPhotoInputDTO;
import com.example.app.multbanck.multbank.dto.PhotoClientAwsDTO;
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
@RequestMapping("/cliente/{clientID}/fotos")

public class PhotoClientController {

    private PhotoClientService photoClientService;


    @Autowired
    public PhotoClientController(PhotoClientService photoClientService) {
        this.photoClientService = photoClientService;
    }


    @PostMapping
    public  void store(@PathVariable Long clientID,
                       ClientPhotoInputDTO clientPhotoInputDTO) throws IOException {
        this.photoClientService.store(clientID, clientPhotoInputDTO);
        this.photoClientService.delete("c4151284-0a0e-4ba6-a290-eeed3654e52eft01.png");

    }

    @GetMapping
    public  ResponseEntity<?> store()  {
       return this.photoClientService.show("c5a2d377-5505-4805-aeb1-ae6599317fecded.jpg");

    }
}
