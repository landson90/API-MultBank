package com.example.app.multbanck.multbank.service;

<<<<<<< HEAD
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
=======
import com.example.app.multbanck.multbank.config.storage.StoragePhotoService;
import com.example.app.multbanck.multbank.dto.ClientPhotoInputDTO;
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
import java.io.InputStream;
>>>>>>> 1.8-cliente-usuario-conta

@Service
public class PhotoClientService {

<<<<<<< HEAD
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

=======
    private PhotoClientRepository photoClientRepository;
    private ClientRepository clientRepository;
    private StoragePhotoService storagePhotoService;

    @Autowired
    public  PhotoClientService(PhotoClientRepository photoClientRepository,
                               ClientRepository clientRepository,
                               StoragePhotoService storagePhotoService) {
        this.photoClientRepository = photoClientRepository;
        this.clientRepository = clientRepository;

        this.storagePhotoService = storagePhotoService;
    }


    public void store(Long clientID,
                                ClientPhotoInputDTO clientPhotoInputDTO) throws IOException {
        ClientEntity clientEntity = this.clientRepository.findById(clientID).get();
        PhotoEntity photoEntity = new PhotoEntity();

        photoEntity.setContentType(clientPhotoInputDTO.getFile().getContentType());
        photoEntity.setFileName(clientPhotoInputDTO.getFile().getOriginalFilename());
        photoEntity.setFileSize(clientPhotoInputDTO.getFile().getSize());
        photoEntity.setClientEntity(clientEntity);

        MultipartFile multipartFile = clientPhotoInputDTO.getFile();

        this.photoClientRepository.save(photoEntity);
        PhotoClientStorageDTO photoClientStorageDTO = new PhotoClientStorageDTO();
        photoClientStorageDTO.setFileName(photoEntity.getFileName());
        photoClientStorageDTO.setInputStream(multipartFile.getInputStream());
        this.storagePhotoService.storageClinetPhoto(photoClientStorageDTO);

    }
>>>>>>> 1.8-cliente-usuario-conta
}
