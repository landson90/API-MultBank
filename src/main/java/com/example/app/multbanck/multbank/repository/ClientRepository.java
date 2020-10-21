package com.example.app.multbanck.multbank.repository;

import com.example.app.multbanck.multbank.model.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {


    ClientEntity findByCpf(String cpf);

    ClientEntity findByUsuarioEntityId(Long id);

}
