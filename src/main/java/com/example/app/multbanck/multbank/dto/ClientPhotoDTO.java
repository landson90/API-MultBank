package com.example.app.multbanck.multbank.dto;

import com.example.app.multbanck.multbank.model.ClientEntity;
import com.example.app.multbanck.multbank.model.ClientPhotoEntity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class ClientPhotoDTO {

    private Long id;
    private ClientEntity clientEntity;
    private String descricao;
    private String contentType;
    private String nomeDoAraquivo;
    private int tamanho;

    public ClientPhotoDTO() {
    }

    public ClientPhotoDTO(ClientPhotoEntity clientPhotoEntity) {
        this.id = clientPhotoEntity.getId();
        this.clientEntity = clientPhotoEntity.getClientEntity();
        this.descricao = clientPhotoEntity.getDescricao();
        this.contentType = clientPhotoEntity.getContentType();
        this.nomeDoAraquivo = clientPhotoEntity.getNomeDoAraquivo();
        this.tamanho = clientPhotoEntity.getTamanho();
    }
    public ClientPhotoEntity convertClientPhotoDtoToClientPhotoEntity(ClientPhotoDTO clientPhotoDTO) {
        return new ClientPhotoEntity(
          clientPhotoDTO.getId(),
          clientPhotoDTO.getClientEntity(),
          clientPhotoDTO.getDescricao(),
          clientPhotoDTO.getContentType(),
          clientPhotoDTO.getNomeDoAraquivo(),
          clientPhotoDTO.getTamanho()
        );
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getNomeDoAraquivo() {
        return nomeDoAraquivo;
    }

    public void setNomeDoAraquivo(String nomeDoAraquivo) {
        this.nomeDoAraquivo = nomeDoAraquivo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
}
