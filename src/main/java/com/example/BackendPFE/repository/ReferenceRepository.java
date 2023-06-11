package com.example.BackendPFE.repository;

import com.example.BackendPFE.model.Reference;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReferenceRepository extends JpaRepository<Reference,Long> {
    List<Reference> findByDemandeId(Long Id);
    @Transactional
    void deleteByDemandeId(Long demandeId);
}