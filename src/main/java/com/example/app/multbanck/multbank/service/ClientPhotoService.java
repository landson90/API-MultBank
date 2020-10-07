package com.example.app.multbanck.multbank.service;

import com.example.app.multbanck.multbank.config.exceptionValidation.ObjectNotFoundException;
import com.example.app.multbanck.multbank.dto.ClientPhotoDTO;
import com.example.app.multbanck.multbank.dto.ClientPhotoFormDTO;
import com.example.app.multbanck.multbank.model.ClientEntity;
import com.example.app.multbanck.multbank.model.ClientPhotoEntity;
import com.example.app.multbanck.multbank.repository.ClientPhotoRepository;
import com.example.app.multbanck.multbank.repository.ClientRepository;
import com.example.app.multbanck.multbank.repository.Implementation.PhotoStoresImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
public class ClientPhotoService {

    private ClientRepository clientRepository;
    private ClientPhotoRepository clientPhotoRepository;
    private PhotoStoresImplementation photoStoresImplementation;

    @Autowired
    public ClientPhotoService(
            ClientRepository clientRepository,
            ClientPhotoRepository clientPhotoRepository,
            PhotoStoresImplementation photoStoresImplementation
            )
    {
        this.clientRepository               = clientRepository;
        this.clientPhotoRepository          = clientPhotoRepository;
        this.photoStoresImplementation      = photoStoresImplementation;
    }

    public ResponseEntity<ClientPhotoDTO> store(Long id,
                                                ClientPhotoFormDTO clientPhotoFormDTO) {
        ClientEntity clientEntity = this.filterClientById(id);
        MultipartFile arquivo = clientPhotoFormDTO.getMultipartFile();
        ClientPhotoDTO clientPhotoDTO = new ClientPhotoDTO();

        clientPhotoDTO.setClientEntity(clientEntity);
        clientPhotoDTO.setDescricao(clientPhotoFormDTO.getDescricao());
        clientPhotoDTO.setContentType(arquivo.getContentType());
        clientPhotoDTO.setNomeDoAraquivo(arquivo.getOriginalFilename());
        clientPhotoDTO.setTamanho((int) arquivo.getSize());
        ClientPhotoEntity clientEntityIsSave = clientPhotoDTO
                .convertClientPhotoDtoToClientPhotoEntity(clientPhotoDTO);

        this.clientPhotoRepository.save(clientEntityIsSave);

        this.photoStoresImplementation.stores(clientPhotoFormDTO.getMultipartFile());

        return ResponseEntity.status(201).body(new ClientPhotoDTO(clientEntityIsSave));
    }

    private ClientEntity filterClientById(long id) {
        Optional<ClientEntity> clientEntity = this.clientRepository.findById(id);
        return clientEntity.
                orElseThrow(() ->
                        new ObjectNotFoundException("Não temos regirtro com esse código ."));
    }

}
