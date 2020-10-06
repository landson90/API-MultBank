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

    public ResponseEntity<AccountDTO> store(AccountDTO accountDTO) {

        accountDTO.setNumberAccount(this.numberAccountValue(accountDTO));
        AccountEntity accountEntity = this.convertAccountDtoToAccountEntity(accountDTO);
        accountEntity = this.accountRepository.save(accountEntity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(accountEntity.getId()).toUri();
        return ResponseEntity.created(uri).body(new AccountDTO(accountEntity));
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

    private AccountEntity convertAccountDtoToAccountEntity(AccountDTO accountDTO) {
        return new AccountEntity(
                accountDTO.getId(),
                accountDTO.getNumberAccount(),
                accountDTO.getClientEntity(),
                accountDTO.getBalance()
        );
    }

    private String numberAccountValue(AccountDTO accountDTO) {
        Random random = new Random();
        int isValue = random.nextInt(1000);
        int isValueDois = random.nextInt(10);
        int isValueTres = random.nextInt(10000);
        String isValueNumberAccaount = Integer.toString(isValue) + "." + isValueTres + "-" + isValueDois;
        return isValueNumberAccaount;
    }


}
