package com.example.app.multbanck.multbank.dto;

import com.example.app.multbanck.multbank.modal.AccountEntity;
import com.example.app.multbanck.multbank.modal.ClientEntity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class AccountDTO {

    private Long id;
    private String numberAccount;
    private ClientEntity clientEntity;

    public AccountDTO() { }

    public AccountDTO(AccountEntity accountEntity) {
        this.id             = accountEntity.getId();
        this.numberAccount  = accountEntity.getNumberAccount();
        this.clientEntity   = accountEntity.getClientEntity();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "id=" + id +
                ", numberAccount='" + numberAccount + '\'' +
                ", clientEntity=" + clientEntity +
                '}';
    }
}
