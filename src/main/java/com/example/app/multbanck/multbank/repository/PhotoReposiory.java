package com.example.app.multbanck.multbank.repository;

import com.example.app.multbanck.multbank.model.PhotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoReposiory extends JpaRepository<PhotoEntity, Long> {
}
