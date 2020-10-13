package com.example.app.multbanck.multbank.controller;

import com.example.app.multbanck.multbank.dto.UserClientDTO;
import com.example.app.multbanck.multbank.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/usuarios")
public class UserController {

     private UserService userService;

     @Autowired
     public UserController(UserService userService) {
         this.userService = userService;
     }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserDTO> store(@RequestBody @Valid UserClientDTO userClientDTO) {
        return this.userService.store(userClientDTO);
    }
}
