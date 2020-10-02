package com.example.app.multbanck.multbank.controller;

import com.example.app.multbanck.multbank.dto.AccountViewDTO;
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
    public ResponseEntity<AccountViewDTO> deposit(@RequestBody DataForTransactionDTO dataForTransactionDTO) {
        return  this.service.deposit(dataForTransactionDTO);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saque")
    public ResponseEntity<AccountViewDTO> accountTakeoff(
            @RequestBody DataForTransactionDTO dataForTransactionDTO) {
        return this.service.accountTakeoff(dataForTransactionDTO);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/tranferencia")
    public ResponseEntity<HistoricTransactionDTO> transaction(
            @RequestBody DataForTransactionDTO dataForTransactionDTO) {
        return this.service.transaction(dataForTransactionDTO);
    }


}
