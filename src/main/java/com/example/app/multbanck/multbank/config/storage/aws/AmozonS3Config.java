package com.example.app.multbanck.multbank.config.storage.aws;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmozonS3Config {

    @Value("${mult.bank.s3.id-chave-acesso}")
    private String idChaveAcesso;

    @Value("${mult.bank.s3.chave-acesso-secreta}")
    private String chaveAcessoSecreta;

    @Value("${mult.bank.s3.bucket}")
    private String bucket;

    @Value("${mult.bank.s3.regiao}")
    private String regiao;

    @Value("${mult.bank.s3.diretorio}")
    private String diretorio;

    // Esse bean vai retorna um instacia de amazon S3
    @Bean
    public AmazonS3 amazonS3() {
        var credentials = new BasicAWSCredentials(this.idChaveAcesso, this.chaveAcessoSecreta);
        return AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(this.regiao)
                .build();
    }
}
