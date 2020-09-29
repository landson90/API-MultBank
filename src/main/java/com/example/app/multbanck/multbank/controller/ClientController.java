package com.example.app.multbanck.multbank.controller;

import com.example.app.multbanck.multbank.dto.ClientDTO;
import com.example.app.multbanck.multbank.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "clientes")
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> index() {
        return this.clientService.index();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ClientDTO> store(@RequestBody ClientDTO clientDTO) {
        return this.clientService.store(clientDTO);
    }
}
