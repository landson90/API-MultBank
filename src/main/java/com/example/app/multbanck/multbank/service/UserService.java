package com.example.app.multbanck.multbank.service;

import com.example.app.multbanck.multbank.dto.UserDTO;
import com.example.app.multbanck.multbank.model.UsuarioEntity;
import com.example.app.multbanck.multbank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public  UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<UserDTO> store(UserDTO userDTO) {
        UsuarioEntity userEntity = this.convertClientDtoToClientEntity(userDTO);
        userEntity = this.userRepository.save(userEntity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userEntity.getId()).toUri();
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
