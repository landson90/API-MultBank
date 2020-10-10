package com.example.app.multbanck.multbank.controller;

import com.example.app.multbanck.multbank.dto.ClientDTO;
import com.example.app.multbanck.multbank.dto.ClientUpdateDTO;
import com.example.app.multbanck.multbank.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "clientes")
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> show(@PathVariable long id) {
        return  this.clientService.show(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable long id,
                                            @RequestBody @Valid ClientUpdateDTO clientDTO) {
        return  this.clientService.update(id, clientDTO);
    }
}
