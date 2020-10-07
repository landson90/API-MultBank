package com.example.app.multbanck.multbank.dto;

import com.example.app.multbanck.multbank.model.HistoricTransactionEntity;
import com.example.app.multbanck.multbank.model.enums.TransactionEnum;

import java.time.OffsetDateTime;

public class HistoricAccountClientTransactionDTO {

    private Long id;
    private String client;
    private int value;
    private String numberAccount;
    private TransactionEnum transactionEnum;
    private OffsetDateTime createAT;

    public HistoricAccountClientTransactionDTO() {
    }

    public HistoricAccountClientTransactionDTO(HistoricTransactionEntity historicTransactionEntity) {
        this.id = historicTransactionEntity.getId();
        this.client = historicTransactionEntity.getAccount().getClientEntity().getName();
        this.value = historicTransactionEntity.getCurrentValue();
        this.numberAccount = historicTransactionEntity.getAccount().getNumberAccount();
        this.transactionEnum = historicTransactionEntity.getTransactionEnum();
        this.createAT = historicTransactionEntity.getCreateAT();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    public TransactionEnum getTransactionEnum() {
        return transactionEnum;
    }

    public void setTransactionEnum(TransactionEnum transactionEnum) {
        this.transactionEnum = transactionEnum;
    }

    public OffsetDateTime getCreateAT() {
        return createAT;
    }

    public void setCreateAT(OffsetDateTime createAT) {
        this.createAT = createAT;
    }
}
