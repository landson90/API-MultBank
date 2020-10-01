package com.example.app.multbanck.multbank.dto;

import com.example.app.multbanck.multbank.modal.HistoricTransactionEntity;
import com.example.app.multbanck.multbank.modal.enums.TransactionEnum;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class HistoricTransactionDTO {

    private long id;
    @NotNull
    @NotEmpty(message = "O Campo conta é obrigatório .")
    private String account;
    private BigDecimal oldValue;
    private TransactionEnum transactionEnum;
    private BigDecimal currentValue;
    private String clientTransaction;

    public HistoricTransactionDTO() { }

    public HistoricTransactionDTO(HistoricTransactionEntity historicTransactionEntity) {
        this.id = historicTransactionEntity.getId();
        this.account = historicTransactionEntity.getAccount();
        this.oldValue = historicTransactionEntity.getOldValue();
        this.transactionEnum = historicTransactionEntity.getTransactionEnum();
        this.currentValue = historicTransactionEntity.getCurrentValue();
        this.clientTransaction = historicTransactionEntity.getClientTransaction();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public BigDecimal getOldValue() {
        return oldValue;
    }

    public void setOldValue(BigDecimal oldValue) {
        this.oldValue = oldValue;
    }

    public TransactionEnum getTransactionEnum() {
        return transactionEnum;
    }

    public void setTransactionEnum(TransactionEnum transactionEnum) {
        this.transactionEnum = transactionEnum;
    }

    public BigDecimal getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(BigDecimal currentValue) {
        this.currentValue = currentValue;
    }

    public String getClientTransaction() {
        return clientTransaction;
    }

    public void setClientTransaction(String clientTransaction) {
        this.clientTransaction = clientTransaction;
    }

    @Override
    public String toString() {
        return "HistoricTransactionDTO{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", oldValue=" + oldValue +
                ", transactionEnum=" + transactionEnum +
                ", currentValue=" + currentValue +
                ", clientTransaction='" + clientTransaction + '\'' +
                '}';
    }
}
