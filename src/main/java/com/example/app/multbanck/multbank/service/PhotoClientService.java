package com.example.app.multbanck.multbank.service;

import com.example.app.multbanck.multbank.dto.ClientPhotoInputDTO;
import com.example.app.multbanck.multbank.model.ClientEntity;
import com.example.app.multbanck.multbank.model.PhotoEntity;
import com.example.app.multbanck.multbank.repository.ClientRepository;
import com.example.app.multbanck.multbank.repository.PhotoClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoClientService {

    private PhotoClientRepository photoClientRepository;
    private ClientRepository clientRepository;
    @Autowired
    public  PhotoClientService(PhotoClientRepository photoClientRepository,
                               ClientRepository clientRepository) {
        this.photoClientRepository = photoClientRepository;
        this.clientRepository = clientRepository;
    }


    public void store(Long clientID, ClientPhotoInputDTO clientPhotoInputDTO) {
        ClientEntity clientEntity = this.clientRepository.findById(clientID).get();
        PhotoEntity photoEntity = new PhotoEntity();
        photoEntity.setContentType(clientPhotoInputDTO.getFile().getContentType());
        photoEntity.setFileName(clientPhotoInputDTO.getFile().getOriginalFilename());
        photoEntity.setFileSize(clientPhotoInputDTO.getFile().getSize());
        photoEntity.setClientEntity(clientEntity);
        this.photoClientRepository.save(photoEntity);

    }
}
