package com.example.BackendPFE.repository;

import com.example.BackendPFE.model.Demande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemandeRepository extends JpaRepository<Demande, Long > {
    List<Demande> findByObjetDemande(String objetDemande);
    Long countByStatut_TypeStatut(String statuType);


}
