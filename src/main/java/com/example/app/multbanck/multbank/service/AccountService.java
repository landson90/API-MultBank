package com.example.app.multbanck.multbank.service;

import com.example.app.multbanck.multbank.config.exceptionValidation.ObjectNotFoundException;
import com.example.app.multbanck.multbank.dto.AccountDTO;
import com.example.app.multbanck.multbank.model.AccountEntity;
import com.example.app.multbanck.multbank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;
import java.util.Random;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {

        this.accountRepository = accountRepository;
    }

    public ResponseEntity<AccountDTO> show(long id) {
        AccountEntity accountEntity = this.filterClientById(id);
        return ResponseEntity.ok().body(new AccountDTO(accountEntity));
    }

    public ResponseEntity<AccountDTO> showAccountNumber(String accountNumber) {
        AccountEntity accountEntity = this.accountRepository.findByNumberAccount(accountNumber);
        return ResponseEntity.ok().body(new AccountDTO(accountEntity));
    }

    private AccountEntity filterClientById(long id) {
        Optional<AccountEntity> accountEntity = this.accountRepository.findById(id);
        return accountEntity.
                orElseThrow(() ->
                        new ObjectNotFoundException("Não temos regirtro com esse código ."));
    }






}
