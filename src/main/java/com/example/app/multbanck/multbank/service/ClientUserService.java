package com.example.app.multbanck.multbank.service;

import ch.qos.logback.core.net.server.Client;
import com.example.app.multbanck.multbank.dto.ClientUserDTO;
import com.example.app.multbanck.multbank.model.ClientEntity;
import com.example.app.multbanck.multbank.model.UsuarioEntity;
import com.example.app.multbanck.multbank.repository.ClientRepository;
import com.example.app.multbanck.multbank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientUserService {

    private UserRepository userRepository;
    private ClientRepository clientRepository;

    @Autowired
    public ClientUserService(UserRepository userRepository, ClientRepository clientRepository
    ) {
        this.clientRepository = clientRepository;
        this.userRepository = userRepository;
    }

    public void createUser(ClientUserDTO clientUserDTO) {
        UsuarioEntity usuarioEntity = this.convertClientUserDtoInUsuarioEntity(clientUserDTO);
        UsuarioEntity isCreateUserEntity = this.userRepository.save(usuarioEntity);
        this.createClient(isCreateUserEntity, clientUserDTO);
    }

    private void createClient(UsuarioEntity isCreateUserEntity, ClientUserDTO clientUserDTO) {
        ClientEntity clientEntity = this.convertClientUserDtoInClientEntity(isCreateUserEntity, clientUserDTO);
        ClientEntity isCreateEntity = this.clientRepository.save(clientEntity);
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

}
