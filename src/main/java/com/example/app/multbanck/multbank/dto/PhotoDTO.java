package com.example.app.multbanck.multbank.dto;

import com.example.app.multbanck.multbank.model.ClientEntity;
import org.springframework.web.multipart.MultipartFile;


import java.util.Objects;

public class PhotoDTO {

    private Long id;
    private String descricao;
    private MultipartFile arquivo;


    public PhotoDTO() {
    }

    public PhotoDTO(Long id,
                    ClientEntity clientEntity,
                    String descricao,
                    MultipartFile arquivo) {
        this.id = id;
        this.descricao = descricao;
        this.arquivo = arquivo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MultipartFile getArquivo() {
        return arquivo;
    }

    public void setArquivo(MultipartFile arquivo) {
        this.arquivo = arquivo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhotoDTO photoDTO = (PhotoDTO) o;
        return id.equals(photoDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
