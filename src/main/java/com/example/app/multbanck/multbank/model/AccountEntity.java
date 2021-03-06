package com.example.app.multbanck.multbank.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "contas")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_conta")
    private String numberAccount;

    @OneToOne
    @JoinColumn(name = "cliente_id", unique = true)
    private ClientEntity clientEntity;

    @Column(name = "saldo")
    private int balance;

    public AccountEntity() { }

    public AccountEntity(Long id,
                         String numberAccount,
                         ClientEntity clientEntity,
                         int balance) {
        this.id = id;
        this.numberAccount = numberAccount;
        this.clientEntity = clientEntity;
        this.balance = balance;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountEntity that = (AccountEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "AccountEntity{" +
                "id=" + id +
                ", numberAccount='" + numberAccount + '\'' +
                ", clientEntity=" + clientEntity +
                '}';
    }
}
