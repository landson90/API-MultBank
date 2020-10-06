package com.example.app.multbanck.multbank.repository;

import com.example.app.multbanck.multbank.model.HistoricTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricTransactionRepository extends JpaRepository<HistoricTransactionEntity, Long> {
}
