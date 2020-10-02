package com.example.app.multbanck.multbank.service;

import com.example.app.multbanck.multbank.dto.AccountDTO;
import com.example.app.multbanck.multbank.dto.ClientDTO;
import com.example.app.multbanck.multbank.dto.DataForTransactionDTO;
import com.example.app.multbanck.multbank.dto.HistoricTransactionDTO;
import com.example.app.multbanck.multbank.modal.AccountEntity;
import com.example.app.multbanck.multbank.modal.ClientEntity;
import com.example.app.multbanck.multbank.modal.HistoricTransactionEntity;
import com.example.app.multbanck.multbank.repository.AccountRepository;
import com.example.app.multbanck.multbank.repository.HistoricTransactionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;

@Service
public class HistoricTransactionService {

    private HistoricTransactionRepository historicTransactionRepository;
    private AccountRepository accountRepository;

    @Autowired
    public HistoricTransactionService(HistoricTransactionRepository historicTransactionRepository,
                                      AccountRepository accountRepository) {
        this.historicTransactionRepository = historicTransactionRepository;
        this.accountRepository = accountRepository;
    }

    public ResponseEntity<HistoricTransactionDTO> deposit(DataForTransactionDTO dataForTransactionDTO) {


        AccountEntity accountEntity = this.accountRepository
                .findByNumberAccount(dataForTransactionDTO.getAccountClient());

        int  accaoutNewValue = accountEntity.getBalance() + dataForTransactionDTO.getValueTransaction();

        HistoricTransactionEntity historicTransactionEntity = this.historicTransactionRepository
                .save(this.convertHistoricToSave(accountEntity,
                dataForTransactionDTO,
                        accaoutNewValue ));

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(historicTransactionEntity.getId()).toUri();
        this.updateBalanceAccount(accountEntity, accaoutNewValue);
        return  ResponseEntity.created(uri).body(new HistoricTransactionDTO(historicTransactionEntity));
    }

    public ResponseEntity<HistoricTransactionDTO> accountTakeoff(DataForTransactionDTO dataForTransactionDTO) {
        AccountEntity accountEntity = this.accountRepository
                .findByNumberAccount(dataForTransactionDTO.getAccountClient());

        int  accaoutNewValue = accountEntity.getBalance() - dataForTransactionDTO.getValueTransaction();

        HistoricTransactionEntity historicTransactionEntity = this.historicTransactionRepository
                .save(this.convertHistoricToSave(accountEntity,
                        dataForTransactionDTO,
                        accaoutNewValue));

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(historicTransactionEntity.getId()).toUri();
        this.updateBalanceAccount(accountEntity, accaoutNewValue);
        return  ResponseEntity.created(uri).body(new HistoricTransactionDTO(historicTransactionEntity));

    }
    public ResponseEntity<HistoricTransactionDTO> transaction(DataForTransactionDTO dataForTransactionDTO) {
        AccountEntity accountEntity = this.accountRepository
                .findByNumberAccount(dataForTransactionDTO.getAccountClient());

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
        return  ResponseEntity.created(uri).body(new HistoricTransactionDTO(historicTransactionEntity));
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
                accountEntity.getNumberAccount(),
                accountEntity.getBalance(),
                dataForTransactionDTO.getTransactionEnum(),
                totalValue,
                accountEntity.getClientEntity().getName()
        );
    }



}
