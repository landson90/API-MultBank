package com.example.app.multbanck.multbank.controller;

import com.example.app.multbanck.multbank.dto.DataForTransactionDTO;
import com.example.app.multbanck.multbank.dto.HistoricTransactionDTO;
import com.example.app.multbanck.multbank.service.HistoricTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/historico")
public class HistoricTransactionController {

    private HistoricTransactionService service;

    @Autowired
    public HistoricTransactionController(HistoricTransactionService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/depositar")
    public ResponseEntity<HistoricTransactionDTO> deposit(@RequestBody DataForTransactionDTO dataForTransactionDTO) {
        return this.service.deposit(dataForTransactionDTO);
    }
}
