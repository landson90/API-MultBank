package com.example.app.multbanck.multbank.service;


import com.example.app.multbanck.multbank.config.storage.S3StoragePhotoService;
import com.example.app.multbanck.multbank.dto.ClientPhotoInputDTO;
import com.example.app.multbanck.multbank.dto.PhotoClientAwsDTO;
import com.example.app.multbanck.multbank.dto.PhotoClientStorageDTO;
import com.example.app.multbanck.multbank.model.ClientEntity;
import com.example.app.multbanck.multbank.model.PhotoEntity;
import com.example.app.multbanck.multbank.repository.ClientRepository;
import com.example.app.multbanck.multbank.repository.PhotoClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;


@Service
public class PhotoClientService {

    private PhotoClientRepository photoClientRepository;
    private ClientRepository clientRepository;
    private S3StoragePhotoService s3StoragePhotoService;

    @Autowired
    public  PhotoClientService(PhotoClientRepository photoClientRepository,
                               ClientRepository clientRepository,
                               S3StoragePhotoService s3StoragePhotoService) {

        this.photoClientRepository = photoClientRepository;
        this.clientRepository = clientRepository;
        this.s3StoragePhotoService = s3StoragePhotoService;
    }

    public void store(Long clientID,
                      ClientPhotoInputDTO clientPhotoInputDTO
    ) throws IOException {

        PhotoEntity photoEntity = this.createClientPhotoInputDTOInPhotoEntity(clientID,
                clientPhotoInputDTO);
        MultipartFile multipartFile = clientPhotoInputDTO.getFile();
        this.photoClientRepository.save(photoEntity);
        this.photoCreateAws(photoEntity, multipartFile);
    }

    private PhotoEntity createClientPhotoInputDTOInPhotoEntity(
            Long clientID, ClientPhotoInputDTO clientPhotoInputDTO
    ) {
        ClientEntity clientEntity = this.clientRepository.findById(clientID).get();
        PhotoEntity photoEntity = new PhotoEntity();

        photoEntity.setContentType(clientPhotoInputDTO.getFile().getContentType());
        photoEntity.setFileName(UUID.randomUUID().toString()+""+clientPhotoInputDTO.getFile().getOriginalFilename());
        photoEntity.setFileSize(clientPhotoInputDTO.getFile().getSize());
        photoEntity.setClientEntity(clientEntity);
        return photoEntity;
    }
    public void delete(String fileName) {
        this.s3StoragePhotoService.deleteClientPhoto(fileName);
    }
    private void photoCreateAws(
            PhotoEntity photoEntity,
            MultipartFile multipartFile) {
        try {
            PhotoClientStorageDTO photoClientStorageDTO = new PhotoClientStorageDTO();
            photoClientStorageDTO.setFileName(photoEntity.getFileName());
            photoClientStorageDTO.setInputStream(multipartFile.getInputStream());
            this.s3StoragePhotoService.storageClinetPhoto(photoClientStorageDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ResponseEntity<PhotoClientAwsDTO> show(String s) {
        PhotoClientAwsDTO photo = this.s3StoragePhotoService.show(s);
        return ResponseEntity.ok().body(photo);
    }
}
