package com.example.app.multbanck.multbank.controller;

import com.example.app.multbanck.multbank.dto.ClientPhotoDTO;
import com.example.app.multbanck.multbank.dto.ClientPhotoFormDTO;
import com.example.app.multbanck.multbank.model.ClientEntity;
import com.example.app.multbanck.multbank.model.ClientPhotoEntity;
import com.example.app.multbanck.multbank.service.ClientPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.UUID;


@RestController
@RequestMapping(value = "clientes/{clienteId}/foto")
public class ClientPhotoController {

    private ClientPhotoService clientPhotoService;

    @Autowired
    public ClientPhotoController(ClientPhotoService clientPhotoService) {
        this.clientPhotoService = clientPhotoService;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ClientPhotoDTO> create(
            @PathVariable Long clienteId,
            ClientPhotoFormDTO clientPhotoFormDTO
    ) {
        return this.clientPhotoService.store(clienteId, clientPhotoFormDTO);
    }

}
