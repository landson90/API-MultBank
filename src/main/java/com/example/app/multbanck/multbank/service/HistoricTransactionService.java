package com.example.app.multbanck.multbank.service;

import com.example.app.multbanck.multbank.dto.*;
import com.example.app.multbanck.multbank.model.AccountEntity;
import com.example.app.multbanck.multbank.model.HistoricTransactionEntity;
import com.example.app.multbanck.multbank.repository.AccountRepository;
import com.example.app.multbanck.multbank.repository.ClientRepository;
import com.example.app.multbanck.multbank.repository.HistoricTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class HistoricTransactionService {

    private HistoricTransactionRepository historicTransactionRepository;
    private AccountRepository accountRepository;
    private ClientRepository clientRepository;


    @Autowired
    public HistoricTransactionService(
            HistoricTransactionRepository historicTransactionRepository,
            AccountRepository accountRepository,
            ClientRepository clientRepository) {
        this.historicTransactionRepository = historicTransactionRepository;
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
    }

    public ResponseEntity<AccountViewDTO> deposit(DataForTransactionDTO dataForTransactionDTO) {
        AccountViewDTO accountViewDTO = new AccountViewDTO();
        if(dataForTransactionDTO.getValueTransaction() <= 0) {
            accountViewDTO.setMsg("Valor infalido");
            return  ResponseEntity.ok().body(accountViewDTO);
        }
        AccountEntity accountEntity = this.accountRepository
                .findByNumberAccount(dataForTransactionDTO.getAccountClient());

        int accaoutNewValue = accountEntity.getBalance() + dataForTransactionDTO.getValueTransaction();

        HistoricTransactionEntity historicTransactionEntity = this.historicTransactionRepository
                .save(this.convertHistoricToSave(accountEntity,
                dataForTransactionDTO,
                        accaoutNewValue ));
        this.updateBalanceAccount(accountEntity, accaoutNewValue);
        accountViewDTO = this.createViewTransaction(accountEntity, dataForTransactionDTO);
        accountViewDTO.setMsg("Deposito realizado com sucesso !");
        return  ResponseEntity.ok().body(accountViewDTO);
    }

    public ResponseEntity<AccountViewDTO> accountTakeoff(DataForTransactionDTO dataForTransactionDTO) {
        AccountViewDTO accountViewDTO = new AccountViewDTO();
        AccountEntity accountEntity = this.accountRepository
                .findByNumberAccount(dataForTransactionDTO.getAccountClient());
        if(accountEntity.getBalance() >= dataForTransactionDTO.getValueTransaction() &&
                dataForTransactionDTO.getValueTransaction() <= 0) {
            accountViewDTO.setMsg("Valor infalido");
            return  ResponseEntity.ok().body(accountViewDTO);
        } else {
            int accaoutNewValue = accountEntity.getBalance() - dataForTransactionDTO.getValueTransaction();

            HistoricTransactionEntity historicTransactionEntity = this.historicTransactionRepository
                    .save(this.convertHistoricToSave(accountEntity,
                            dataForTransactionDTO,
                            accaoutNewValue));

            this.updateBalanceAccount(accountEntity, accaoutNewValue);
            accountViewDTO = this.createViewTransaction(accountEntity, dataForTransactionDTO);
            accountViewDTO.setMsg("Saque realizado com sucesso !");
            return ResponseEntity.ok().body(accountViewDTO);
        }

    }
    public ResponseEntity<AccountViewDTO> transaction(DataForTransactionDTO dataForTransactionDTO) {
        AccountViewDTO accountViewDTO = new AccountViewDTO();
        AccountEntity accountEntity = this.accountRepository
                .findByNumberAccount(dataForTransactionDTO.getAccountClient());
        if(accountEntity.getBalance() >= dataForTransactionDTO.getValueTransaction() &&
                dataForTransactionDTO.getValueTransaction() <= 0) {
            accountViewDTO.setMsg("Valor infalido");
            return  ResponseEntity.ok().body(accountViewDTO);
        } else {

            int  accaoutNewValue = accountEntity.getBalance() - dataForTransactionDTO.getValueTransaction();

            HistoricTransactionEntity historicTransactionEntity = this.historicTransactionRepository
                    .save(this.convertHistoricToSave(accountEntity,
                            dataForTransactionDTO,
                            accaoutNewValue));

            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(historicTransactionEntity.getId()).toUri();

            this.updateBalanceAccount(accountEntity, accaoutNewValue);
            this.updateTransactionOldClient(dataForTransactionDTO);
            accountViewDTO = this.createViewTransaction(accountEntity, dataForTransactionDTO);
            accountViewDTO.setClientOldClient(this.ClientOldName(dataForTransactionDTO));
            accountViewDTO.setMsg("Transferencia realizado com sucesso !");
            return  ResponseEntity.ok().body(accountViewDTO);
        }

    }
    private String ClientOldName(DataForTransactionDTO dataForTransactionDTO) {
        AccountEntity accountEntity = this.accountRepository
                .findByNumberAccount(dataForTransactionDTO.getAccountOtherClient());
        String clientName = accountEntity.getClientEntity().getName();
        this.ClientOldTransaction(accountEntity, dataForTransactionDTO);
        return clientName;
    }

    private void ClientOldTransaction(AccountEntity accountEntity, DataForTransactionDTO dataForTransactionDTO) {
        this.historicTransactionRepository.save(this.convertHistoricToSave(accountEntity,
                dataForTransactionDTO,
                accountEntity.getBalance()));
    }
    private void updateTransactionOldClient(DataForTransactionDTO dataForTransactionDTO) {
        AccountEntity accountEntityOldClient = this.accountRepository
                                                   .findByNumberAccount(dataForTransactionDTO.getAccountOtherClient());
        int accountValue = accountEntityOldClient.getBalance() + dataForTransactionDTO.getValueTransaction();
        accountEntityOldClient.setBalance(accountValue);
        this.accountRepository.save(accountEntityOldClient);
    }

    private void updateBalanceAccount(AccountEntity accountEntity, int valor) {
        AccountEntity account = this.accountRepository.findByNumberAccount(accountEntity.getNumberAccount());
        account.setBalance(valor);
        this.accountRepository.save(accountEntity);
    }
    private HistoricTransactionEntity convertHistoricToSave(
            AccountEntity accountEntity,
            DataForTransactionDTO dataForTransactionDTO,
            int totalValue) {

        HistoricTransactionDTO historicTransactionDTO = new HistoricTransactionDTO();

        return new HistoricTransactionEntity(
                historicTransactionDTO.getId(),
                accountEntity,
                accountEntity.getBalance(),
                dataForTransactionDTO.getTransactionEnum(),
                totalValue,
                accountEntity.getClientEntity().getName()
        );
    }

    private AccountViewDTO createViewTransaction(AccountEntity accountEntity,
                                                 DataForTransactionDTO dataForTransactionDTO) {

        AccountViewDTO accountViewDTO = new AccountViewDTO();
        accountViewDTO.setClient(accountEntity.getClientEntity().getName());
        accountViewDTO.setTransfer(dataForTransactionDTO.getTransactionEnum().toString());
        accountViewDTO.setValue(accountEntity.getBalance());
        return accountViewDTO;
    }

    public ResponseEntity<List<HistoricTransactionEntity>> accountHistoricTransactionList(Long id) {
        List<HistoricTransactionEntity> list = this.historicTransactionRepository.findAllAccountHistoricTransactionList(id);
        return ResponseEntity.ok().body(list);
    }
}
