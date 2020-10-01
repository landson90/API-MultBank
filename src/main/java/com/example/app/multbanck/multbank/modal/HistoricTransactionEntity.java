package com.example.app.multbanck.multbank.modal;

import com.example.app.multbanck.multbank.modal.enums.TransactionEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table( name = "historico_transaçao")
public class HistoricTransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "numero_conta")
    private String account;

    @Column(name = "valor_antigo")
    private BigDecimal oldValue;

    @Column(name = "tipo_transacao")
    private TransactionEnum transactionEnum;

    @Column(name = "valor_atual")
    private BigDecimal currentValue;

    @Column(name = "transferencia_cliente")
    private String clientTransaction;

    public HistoricTransactionEntity() { }

    public HistoricTransactionEntity(long id,
                                     String account,
                                     BigDecimal oldValue,
                                     TransactionEnum transactionEnum,
                                     BigDecimal currentValue,
                                     String clientTransaction) {
        this.id = id;
        this.account = account;
        this.oldValue = oldValue;
        this.transactionEnum = transactionEnum;
        this.currentValue = currentValue;
        this.clientTransaction = clientTransaction;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoricTransactionEntity that = (HistoricTransactionEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "HistoricTransactionEntity{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", oldValue=" + oldValue +
                ", transactionEnum=" + transactionEnum +
                ", currentValue=" + currentValue +
                ", clientTransaction='" + clientTransaction + '\'' +
                '}';
    }
}
