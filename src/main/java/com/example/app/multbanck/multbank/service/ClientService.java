package com.example.app.multbanck.multbank.service;

import com.example.app.multbanck.multbank.dto.ClientDTO;
import com.example.app.multbanck.multbank.modal.ClientEntity;
import com.example.app.multbanck.multbank.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public ResponseEntity<List<ClientDTO>> index() {
        List<ClientEntity> clientEntities = this.clientRepository.findAll();
        List<ClientDTO> clientDTOS = clientEntities.stream().map(clients -> new ClientDTO(clients))
                                                            .collect(Collectors.toList());

        return  ResponseEntity.ok().body(clientDTOS);
    }
}
