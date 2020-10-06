package com.example.app.multbanck.multbank.dto;

import com.example.app.multbanck.multbank.model.AccountEntity;
import com.example.app.multbanck.multbank.model.ClientEntity;

public class AccountDTO {

    private Long id;
    private String numberAccount;
    private ClientEntity clientEntity;
    private int balance;

    public AccountDTO() { }

    public AccountDTO(AccountEntity accountEntity) {
        this.id             = accountEntity.getId();
        this.numberAccount  = accountEntity.getNumberAccount();
        this.clientEntity   = accountEntity.getClientEntity();
        this.balance        = accountEntity.getBalance();
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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
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
