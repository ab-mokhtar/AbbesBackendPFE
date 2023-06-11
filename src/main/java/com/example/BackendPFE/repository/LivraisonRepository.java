package com.example.BackendPFE.repository;

import com.example.BackendPFE.model.Evolution;
import com.example.BackendPFE.model.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivraisonRepository extends JpaRepository<Livraison, Long > {
}
