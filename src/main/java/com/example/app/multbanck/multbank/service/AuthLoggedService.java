package com.example.app.multbanck.multbank.service;

import com.example.app.multbanck.multbank.dto.AuthLoggedDTO;
import com.example.app.multbanck.multbank.model.AccountEntity;
import com.example.app.multbanck.multbank.model.ClientEntity;
import com.example.app.multbanck.multbank.model.UsuarioEntity;
import com.example.app.multbanck.multbank.repository.AccountRepository;
import com.example.app.multbanck.multbank.repository.ClientRepository;
import com.example.app.multbanck.multbank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthLoggedService {

    private UserRepository userRepository;
    private ClientRepository clientRepository;
    private AccountRepository accountRepository;

    @Autowired
    public AuthLoggedService(
            UserRepository userRepository,
            ClientRepository clientRepository,
            AccountRepository accountRepository
    ) {
        this.userRepository = userRepository;
        this.clientRepository = clientRepository;
        this.accountRepository = accountRepository;
    }

    public ResponseEntity<AuthLoggedDTO> showUserLogged(String token, String email) {

        UsuarioEntity usuarioEntity = this.userRepository.findByEmail(email).get();
        UsuarioEntity nomeGrupo =  this.userRepository.findByEmail("roberta").get(); // fazer null

        ClientEntity clientEntity   = this.getClient(usuarioEntity.getId());
        AccountEntity accountEntity = this.getAccount(clientEntity.getId());
        AuthLoggedDTO authLoggedDTO = new AuthLoggedDTO(
                usuarioEntity.getId(),
                accountEntity.getId(),
                usuarioEntity.getName(),
                usuarioEntity.getEmail(),
                accountEntity.getNumberAccount(),
                accountEntity.getBalance(),
                token);
        return ResponseEntity.ok().body(authLoggedDTO);
    }

    private ClientEntity getClient(Long userId) {
        ClientEntity clientEntity   = this.clientRepository.findByUsuarioEntityId(userId);
        return clientEntity;
    }

    private AccountEntity getAccount(Long accountId) {
        AccountEntity accountEntity = this.accountRepository.findByClientEntityId(accountId);
        return accountEntity;
    }
}
