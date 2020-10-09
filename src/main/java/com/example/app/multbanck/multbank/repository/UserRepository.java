package com.example.app.multbanck.multbank.repository;

import com.example.app.multbanck.multbank.model.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findByEmail(String email);
    @Query("SELECT u FROM UsuarioEntity u where email = :email")
    UsuarioEntity filtroPorEmail(String email);

}
