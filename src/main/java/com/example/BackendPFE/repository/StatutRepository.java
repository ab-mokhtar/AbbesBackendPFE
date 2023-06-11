package com.example.BackendPFE.repository;

import com.example.BackendPFE.model.Charge;
import com.example.BackendPFE.model.Statut;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StatutRepository extends JpaRepository<Statut,Long> {
    List<Statut> findByDemandeId(Long Id);
    @Transactional
    void deleteByDemandeId(Long demandeId);
}
