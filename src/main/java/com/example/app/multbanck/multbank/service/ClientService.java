package com.example.app.multbanck.multbank.service;

import com.example.app.multbanck.multbank.config.exceptionValidation.ObjectNotFoundException;
import com.example.app.multbanck.multbank.dto.ClientDTO;
import com.example.app.multbanck.multbank.dto.ClientUpdateDTO;
import com.example.app.multbanck.multbank.dto.UserClientDTO;
import com.example.app.multbanck.multbank.model.ClientEntity;
import com.example.app.multbanck.multbank.repository.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
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

        return ResponseEntity.ok().body(clientDTOS);
    }


    public ResponseEntity<ClientDTO> store(ClientDTO clientDTO) {
        ClientEntity clientEntity = this.convertClientDtoToClientEntity(clientDTO);
        clientEntity = this.clientRepository.save(clientEntity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(clientEntity.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClientDTO(clientEntity));
    }

    public ResponseEntity<ClientDTO> show(long id) {
        ClientEntity clientEntity = this.filterClientById(id);
        return ResponseEntity.ok().body(new ClientDTO(clientEntity));
    }



    public ResponseEntity<ClientDTO> update(long id, ClientUpdateDTO clientDTO) {
        ClientEntity clientEntity = this.filterClientById(id);
        BeanUtils.copyProperties(
                this.convertClientUpdateDtoToClientEntity(clientDTO),
                clientEntity,
                "id");
        this.clientRepository.save(clientEntity);
        return ResponseEntity.ok().body(new ClientDTO(clientEntity));
    }

    private ClientEntity filterClientById(long id) {
        Optional<ClientEntity> clientEntity = this.clientRepository.findById(id);
        return clientEntity.
                orElseThrow(() ->
                        new ObjectNotFoundException("Não temos regirtro com esse código ."));
    }

    private ClientEntity convertClientDtoToClientEntity(ClientDTO clientDTO) {
        return new ClientEntity(
                clientDTO.getId(),
                clientDTO.getName(),
                clientDTO.getDateOfBirth(),
                clientDTO.getCpf(),
                clientDTO.getUserId());
    }
    private ClientEntity convertClientUpdateDtoToClientEntity(ClientUpdateDTO clientDTO) {
        return new ClientEntity(
                clientDTO.getId(),
                clientDTO.getName(),
                clientDTO.getDateOfBirth(),
                clientDTO.getCpf(),
                clientDTO.getUserId());
    }

    public void createClient(UserClientDTO userClientDTO) {
        UserClientDTO clientDTO = userClientDTO;
        this.clientRepository.save(clientDTO.convertUserClientDTOToClientEntity(userClientDTO));
    }
}
