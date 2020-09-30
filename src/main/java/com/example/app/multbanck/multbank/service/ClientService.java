package com.example.app.multbanck.multbank.service;

import com.example.app.multbanck.multbank.dto.ClientDTO;
import com.example.app.multbanck.multbank.modal.ClientEntity;
import com.example.app.multbanck.multbank.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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


    public ResponseEntity<ClientDTO> store(ClientDTO clientDTO) {

        ClientEntity clientEntity = this.convertClientDtoToClientEntity(clientDTO);
        clientEntity = this.clientRepository.save(clientEntity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(clientEntity.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClientDTO(clientEntity));
    }

    private ClientEntity convertClientDtoToClientEntity(ClientDTO clientDTO) {
        return new ClientEntity(
                clientDTO.getId(),
                clientDTO.getName(),
                clientDTO.getDateOfBirth(),
                clientDTO.getCpf());
    }
}
