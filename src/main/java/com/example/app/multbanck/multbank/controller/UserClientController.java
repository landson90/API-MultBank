package com.example.app.multbanck.multbank.controller;

import com.example.app.multbanck.multbank.dto.ClientUserDTO;
import com.example.app.multbanck.multbank.service.ClientUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/usuarios")
public class UserClientController {


    private ClientUserService clientUserService;

    @Autowired
    public UserClientController(ClientUserService clientUserService) {

        this.clientUserService = clientUserService;
    }

    @PostMapping
    public void createUserClient(
            @RequestBody @Valid ClientUserDTO clientUserDTO
            ) {
        this.clientUserService.createUser(clientUserDTO);
    }
}
