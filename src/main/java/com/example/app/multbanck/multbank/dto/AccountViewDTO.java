package com.example.app.multbanck.multbank.dto;

public class AccountViewDTO {

    private String msg;
    private int value;
    private String client;
    private String clientOldClient;
    private String transfer;

    public AccountViewDTO() {};

    public AccountViewDTO(String msg, int value, String client, String clientOldClient, String transfer) {
        this.msg = msg;
        this.value = value;
        this.client = client;
        this.clientOldClient = clientOldClient;
        this.transfer = transfer;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getClientOldClient() {
        return clientOldClient;
    }

    public void setClientOldClient(String clientOldClient) {
        this.clientOldClient = clientOldClient;
    }

    public String getTransfer() {
        return transfer;
    }

    public void setTransfer(String transfer) {
        this.transfer = transfer;
    }


}
