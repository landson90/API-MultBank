package com.example.app.multbanck.multbank.config.exceptionValidation;

public class DataIntegrityViolationExceptionCPF extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public DataIntegrityViolationExceptionCPF(String msg) {
        super(msg);
    }

    public DataIntegrityViolationExceptionCPF(String msg, Throwable cause) {
        super(msg);
    }
}
