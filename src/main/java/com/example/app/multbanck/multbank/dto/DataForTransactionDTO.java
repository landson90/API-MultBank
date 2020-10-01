package com.example.app.multbanck.multbank.dto;

import com.example.app.multbanck.multbank.modal.enums.TransactionEnum;

import java.math.BigDecimal;

public class DataForTransactionDTO {

    private String accountClient;
    private BigDecimal valueTransaction;
    private String  accountOtherClient;
    private TransactionEnum transactionEnum;

    public DataForTransactionDTO() { }

    public DataForTransactionDTO(String accountClient,
                                 BigDecimal valueTransaction,
                                 String accountOtherClient,
                                 TransactionEnum transactionEnum) {
        this.accountClient = accountClient;
        this.valueTransaction = valueTransaction;
        this.accountOtherClient = accountOtherClient;
    }

    public String getAccountClient() {
        return accountClient;
    }

    public void setAccountClient(String accountClient) {
        this.accountClient = accountClient;
    }

    public BigDecimal getValueTransaction() {
        return valueTransaction;
    }

    public void setValueTransaction(BigDecimal valueTransaction) {
        this.valueTransaction = valueTransaction;
    }

    public String getAccountOtherClient() {
        return accountOtherClient;
    }

    public void setAccountOtherClient(String accountOtherClient) {
        this.accountOtherClient = accountOtherClient;
    }

    public TransactionEnum getTransactionEnum() {
        return transactionEnum;
    }

    public void setTransactionEnum(TransactionEnum transactionEnum) {
        this.transactionEnum = transactionEnum;
    }
}
