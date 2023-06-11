package com.example.BackendPFE.repository;

import com.example.BackendPFE.model.Charge;
import com.example.BackendPFE.model.Priorite;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrioriteRepository extends JpaRepository<Priorite,Long> {
    List<Priorite> findByDemandeId(Long Id);
    @Transactional
    void deleteByDemandeId(Long demandeId);
}
