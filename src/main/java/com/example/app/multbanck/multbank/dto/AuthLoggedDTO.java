package com.example.app.multbanck.multbank.dto;

public class AuthLoggedDTO {
    private Long clientId;
    private Long accountId;
    private String name;
    private String email;
    private String account;
    private int balance;
    private String token;

    public AuthLoggedDTO() {
    }

    public AuthLoggedDTO(Long clientId, Long accountId, String name, String email, String account, int balance, String token) {
        this.clientId = clientId;
        this.accountId = accountId;
        this.name = name;
        this.email = email;
        this.account = account;
        this.balance = balance;
        this.token = token;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
