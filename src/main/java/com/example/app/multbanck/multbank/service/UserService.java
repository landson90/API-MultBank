package com.example.app.multbanck.multbank.service;

import com.example.app.multbanck.multbank.dto.ClientDTO;
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

    @Autowired
    public  UserService(UserRepository userRepository,
                        ClientRepository clientRepository) {
        this.userRepository = userRepository;
        this.clientRepository = clientRepository;
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
        this.createClient(userClientDTO);
        return ResponseEntity.created(uri).body(new UserDTO(userEntity));
    }

    private void createClient(UserClientDTO userClientDTO) {
        UserClientDTO clientDTO = userClientDTO;
        this.clientRepository.save(clientDTO.convertUserClientDTOToClientEntity(userClientDTO));
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
