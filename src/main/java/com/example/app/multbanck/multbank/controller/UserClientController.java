package com.example.app.multbanck.multbank.controller;

import com.example.app.multbanck.multbank.dto.ClientUserDTO;
import com.example.app.multbanck.multbank.dto.UserDTO;
import com.example.app.multbanck.multbank.service.ClientUserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/usuarios")
public class UserClientController {


    private ClientUserAccountService clientUserService;

    @Autowired
    public UserClientController(ClientUserAccountService clientUserService) {

        this.clientUserService = clientUserService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUserClient(
            @RequestBody  @Valid ClientUserDTO clientUserDTO
            ) {
       return this.clientUserService.createUser(clientUserDTO);
    }
}
