package com.example.app.multbanck.multbank.controller;

import com.example.app.multbanck.multbank.dto.AccountDTO;
import com.example.app.multbanck.multbank.dto.ClientDTO;
import com.example.app.multbanck.multbank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/contas")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AccountDTO> store(@RequestBody @Valid AccountDTO accountDTO) {
        return this.accountService.store(accountDTO);
    }
}
