package com.example.app.multbanck.multbank.config.storage;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.app.multbanck.multbank.dto.PhotoClientAwsDTO;
import com.example.app.multbanck.multbank.dto.PhotoClientStorageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URL;

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

    @Override
    public void deleteClientPhoto(String  fileName) {
        try{
            String caminho = this.getCaminho(fileName);
            var deleteFileAws = new DeleteObjectRequest(
                    this.bucket,
                    caminho
            );
            amazonS3.deleteObject(deleteFileAws);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public PhotoClientAwsDTO show(String fileName) {
        String caminho = this.getCaminho(fileName);
        URL url = amazonS3.getUrl(
                this.bucket,
                caminho
        );
        PhotoClientAwsDTO photoS3 =new PhotoClientAwsDTO();
        photoS3.setUrl(url.toString());
        return photoS3;
    }

    private String getCaminho(String nomeArquivo) {
        return String.format("%s/%s", this.diretorio, nomeArquivo);
    }
}
