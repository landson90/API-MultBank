package com.example.app.multbanck.multbank.controller;

import com.example.app.multbanck.multbank.dto.AccountViewDTO;
import com.example.app.multbanck.multbank.dto.DataForTransactionDTO;
import com.example.app.multbanck.multbank.dto.HistoricAccountClientTransactionDTO;
import com.example.app.multbanck.multbank.service.HistoricTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Sort.Direction;


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
    public ResponseEntity<AccountViewDTO> transaction(
            @RequestBody DataForTransactionDTO dataForTransactionDTO) {
        return this.service.transaction(dataForTransactionDTO);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Page<HistoricAccountClientTransactionDTO>> accountHistoricTransactionList(
            @PathVariable Long id,
            @PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 6) Pageable pag
    ) {
        return this.service.accountHistoricTransactionList(id, pag);
    }



}
