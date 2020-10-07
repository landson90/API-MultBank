package com.example.app.multbanck.multbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientPhotoRepository extends JpaRepository<ClientPhotoEntity, Long> {
}
