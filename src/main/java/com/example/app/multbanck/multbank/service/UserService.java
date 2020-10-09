package com.example.app.multbanck.multbank.service;

import com.example.app.multbanck.multbank.dto.UserClientDTO;
import com.example.app.multbanck.multbank.dto.UserDTO;
import com.example.app.multbanck.multbank.model.UsuarioEntity;
import com.example.app.multbanck.multbank.repository.ClientRepository;
import com.example.app.multbanck.multbank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Service
public class UserService {

    private UserRepository userRepository;
    private ClientRepository clientRepository;
    private ClientService clientService;

    @Autowired
    public  UserService(UserRepository userRepository,
                        ClientRepository clientRepository,
                        ClientService clientService) {
        this.userRepository = userRepository;
        this.clientRepository = clientRepository;
        this.clientService = clientService;
    }

    public ResponseEntity<UserDTO> store(UserClientDTO userClientDTO) {

        UserDTO userDTO = new UserDTO();

        UsuarioEntity userEntity = this.convertClientDtoToClientEntity(userDTO
                .convertUserClientDTO(userClientDTO));

        userEntity = this.userRepository.save(userEntity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userEntity.getId()).toUri();
        userClientDTO.setUserId(userEntity.getId());

        this.clientService.createClient(userClientDTO);
        return ResponseEntity.created(uri).body(new UserDTO(userEntity));
    }



    private UsuarioEntity convertClientDtoToClientEntity(UserDTO userDTO) {
        return new UsuarioEntity(
                userDTO.getId(),
                userDTO.getNome(),
                userDTO.getEmail(),
                userDTO.getPassword()
        );
    }

}