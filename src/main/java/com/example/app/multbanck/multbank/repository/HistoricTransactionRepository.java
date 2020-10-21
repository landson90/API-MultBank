package com.example.app.multbanck.multbank.repository;


import com.example.app.multbanck.multbank.model.HistoricTransactionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoricTransactionRepository extends JpaRepository<HistoricTransactionEntity, Long> {

    @Query("SELECT h FROM HistoricTransactionEntity h where account.id = :id ORDER BY createAT")
    Page<HistoricTransactionEntity> findAllAccountHistoricTransactionList(@Param("id") Long id, Pageable pag);
}
