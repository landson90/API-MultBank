package com.example.app.multbanck.multbank.service;

import ch.qos.logback.core.net.server.Client;
import com.example.app.multbanck.multbank.dto.AccountDTO;
import com.example.app.multbanck.multbank.dto.ClientUserDTO;
import com.example.app.multbanck.multbank.model.AccountEntity;
import com.example.app.multbanck.multbank.model.ClientEntity;
import com.example.app.multbanck.multbank.model.UsuarioEntity;
import com.example.app.multbanck.multbank.repository.AccountRepository;
import com.example.app.multbanck.multbank.repository.ClientRepository;
import com.example.app.multbanck.multbank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ClientUserAccountService {

    private UserRepository userRepository;
    private ClientRepository clientRepository;
    private AccountRepository accountRepository;


    @Autowired
    public ClientUserAccountService(UserRepository userRepository,
                                    ClientRepository clientRepository,
                                    AccountRepository accountRepository
    ) {
        this.clientRepository = clientRepository;
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    public void createUser(ClientUserDTO clientUserDTO) {
        UsuarioEntity usuarioEntity = this.convertClientUserDtoInUsuarioEntity(clientUserDTO);
        UsuarioEntity isCreateUserEntity = this.userRepository.save(usuarioEntity);
        this.createClient(isCreateUserEntity, clientUserDTO);
    }

    private void createClient(UsuarioEntity isCreateUserEntity, ClientUserDTO clientUserDTO) {
        ClientEntity clientEntity = this.convertClientUserDtoInClientEntity(isCreateUserEntity, clientUserDTO);
        ClientEntity isCreateEntity = this.clientRepository.save(clientEntity);
        this.createAccount(isCreateEntity);
    }

    private void createAccount(ClientEntity isCreateEntity) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setClientEntity(isCreateEntity);
        accountEntity.setNumberAccount(this.numberAccountValue());
        this.accountRepository.save(accountEntity);

    }

    private ClientEntity convertClientUserDtoInClientEntity(UsuarioEntity isCreateUserEntity, ClientUserDTO clientUserDTO) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setCpf(clientUserDTO.getCpf());
        clientEntity.setName(clientUserDTO.getNome());
        clientEntity.setDateOfBirth(clientUserDTO.getDateOfBirth());
        clientEntity.setUsuarioEntity(isCreateUserEntity);
        return clientEntity;
    }

    private UsuarioEntity convertClientUserDtoInUsuarioEntity(ClientUserDTO clientUserDTO) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setName(clientUserDTO.getNome());
        usuarioEntity.setEmail(clientUserDTO.getEmail());
        usuarioEntity.setPassword(clientUserDTO.getPassword());
        return  usuarioEntity;
    }

    private String numberAccountValue() {
        Random random = new Random();
        int isValue = random.nextInt(1000);
        int isValueDois = random.nextInt(10);
        int isValueTres = random.nextInt(10000);
        String isValueNumberAccaount = Integer.toString(isValue) + "." + isValueTres + "-" + isValueDois;
        return isValueNumberAccaount;
    }

}
