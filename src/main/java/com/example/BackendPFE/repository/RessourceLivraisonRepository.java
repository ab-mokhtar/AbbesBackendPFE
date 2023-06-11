package com.example.BackendPFE.repository;

import com.example.BackendPFE.model.Evolution;
import com.example.BackendPFE.model.RessourceLivraison;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RessourceLivraisonRepository extends JpaRepository<RessourceLivraison, Long > {
}
