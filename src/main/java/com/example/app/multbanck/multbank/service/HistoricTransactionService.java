package com.example.app.multbanck.multbank.service;

import com.example.app.multbanck.multbank.repository.HistoricTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoricTransactionService {

    private HistoricTransactionRepository historicTransactionRepository;

    @Autowired
    public HistoricTransactionService(HistoricTransactionRepository historicTransactionRepository) {
        this.historicTransactionRepository = historicTransactionRepository;
    }
}
