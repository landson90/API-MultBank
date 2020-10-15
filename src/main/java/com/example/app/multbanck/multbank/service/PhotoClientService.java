package com.example.app.multbanck.multbank.service;


import com.example.app.multbanck.multbank.config.storage.S3StoragePhotoService;
import com.example.app.multbanck.multbank.config.storage.StoragePhotoService;
import com.example.app.multbanck.multbank.dto.ClientPhotoInputDTO;
import com.example.app.multbanck.multbank.dto.PhotoClientDTO;
import com.example.app.multbanck.multbank.dto.PhotoClientStorageDTO;
import com.example.app.multbanck.multbank.dto.PhotoDTO;
import com.example.app.multbanck.multbank.model.ClientEntity;
import com.example.app.multbanck.multbank.model.PhotoEntity;
import com.example.app.multbanck.multbank.repository.ClientRepository;
import com.example.app.multbanck.multbank.repository.PhotoClientRepository;
import com.example.app.multbanck.multbank.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.UUID;


@Service
public class PhotoClientService {

    private PhotoClientRepository photoClientRepository;
    private ClientRepository clientRepository;
    private StoragePhotoService storagePhotoService;
    private S3StoragePhotoService s3StoragePhotoService;

    @Autowired
    public  PhotoClientService(PhotoClientRepository photoClientRepository,
                               ClientRepository clientRepository,
                               StoragePhotoService storagePhotoService,
                               S3StoragePhotoService s3StoragePhotoService) {

        this.photoClientRepository = photoClientRepository;
        this.clientRepository = clientRepository;
        this.storagePhotoService = storagePhotoService;
        this.s3StoragePhotoService = s3StoragePhotoService;
    }


    public void store(Long clientID,
                                ClientPhotoInputDTO clientPhotoInputDTO) throws IOException {
        ClientEntity clientEntity = this.clientRepository.findById(clientID).get();
        PhotoEntity photoEntity = new PhotoEntity();

        photoEntity.setContentType(clientPhotoInputDTO.getFile().getContentType());
        photoEntity.setFileName(UUID.randomUUID().toString()+""+clientPhotoInputDTO.getFile().getOriginalFilename());
        photoEntity.setFileSize(clientPhotoInputDTO.getFile().getSize());
        photoEntity.setClientEntity(clientEntity);

        MultipartFile multipartFile = clientPhotoInputDTO.getFile();

        this.photoClientRepository.save(photoEntity);
        PhotoClientStorageDTO photoClientStorageDTO = new PhotoClientStorageDTO();
        photoClientStorageDTO.setFileName(photoEntity.getFileName());
        photoClientStorageDTO.setInputStream(multipartFile.getInputStream());
        this.s3StoragePhotoService.storageClinetPhoto(photoClientStorageDTO);

    }

}
