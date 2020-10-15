package com.example.app.multbanck.multbank.config.storage;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.app.multbanck.multbank.dto.PhotoClientStorageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class S3StoragePhotoService implements StorageService{

    @Autowired
    private AmazonS3 amazonS3;

    @Value("${mult.bank.s3.bucket}")
    private String bucket;

    @Value("${mult.bank.s3.diretorio}")
    private String diretorio;


    @Override
    public void storageClinetPhoto(PhotoClientStorageDTO photoClientStorageDTO) {
        var objectMetadata = new ObjectMetadata();
        var putObjectRequest = new PutObjectRequest(
                this.bucket,
                this.getCaminho(photoClientStorageDTO.getFileName()),
                photoClientStorageDTO.getInputStream(),
                objectMetadata
        );
        amazonS3.putObject(putObjectRequest);
    }

    private String getCaminho(String nomeArquivo) {
        return String.format("%s/%s", this.diretorio, nomeArquivo);
    }
}
