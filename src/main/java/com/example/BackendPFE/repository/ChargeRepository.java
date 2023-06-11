package com.example.BackendPFE.repository;

import com.example.BackendPFE.model.Charge;
import com.example.BackendPFE.model.Commentaire;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChargeRepository extends JpaRepository<Charge,Long> {
    List<Charge> findByDemandeId(Long Id);
    @Transactional
    void deleteByDemandeId(Long demandeId);
}
