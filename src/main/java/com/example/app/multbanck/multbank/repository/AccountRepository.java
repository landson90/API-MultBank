package com.example.app.multbanck.multbank.repository;

import com.example.app.multbanck.multbank.modal.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    AccountEntity findByNumberAccount(String numberAccount);
}
