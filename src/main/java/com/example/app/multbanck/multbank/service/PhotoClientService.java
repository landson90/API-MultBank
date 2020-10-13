package com.example.app.multbanck.multbank.service;

import com.example.app.multbanck.multbank.dto.PhotoClientDTO;
import com.example.app.multbanck.multbank.dto.PhotoDTO;
import com.example.app.multbanck.multbank.model.ClientEntity;
import com.example.app.multbanck.multbank.model.PhotoEntity;
import com.example.app.multbanck.multbank.repository.ClientRepository;
import com.example.app.multbanck.multbank.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Service
public class PhotoClientService {

    private PhotoRepository photoRepository;
    private ClientRepository clientRepository;

    @Autowired
    public PhotoClientService(PhotoRepository photoRepository,
                              ClientRepository clientRepository) {
        this.photoRepository = photoRepository;
        this.clientRepository = clientRepository;
    }


    public ResponseEntity<PhotoClientDTO> store(Long clientId, PhotoDTO photoDTO) {
        ClientEntity clientEntity = this.clientRepository.findById(clientId).get();
        PhotoEntity photoEntity   = this.convertPhotoDTOInPhotoEntity(clientEntity, photoDTO);
        PhotoEntity photoEntityCreate = this.photoRepository.save(photoEntity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(photoEntityCreate.getId()).toUri();
        return ResponseEntity.created(uri).body(new PhotoClientDTO(photoEntityCreate));


    }
    private PhotoEntity convertPhotoDTOInPhotoEntity(ClientEntity clientEntity,
                                                           PhotoDTO photoDTO)
    {
        PhotoEntity photoEntity = new PhotoEntity();
        photoEntity.setClientEntity(clientEntity);
        photoEntity.setFileName(photoDTO.getMultipartFile().getOriginalFilename());
        photoEntity.setFileSize(photoDTO.getMultipartFile().getSize());
        photoEntity.setContentType(photoDTO.getMultipartFile().getContentType());

        return photoEntity;

    }

}
