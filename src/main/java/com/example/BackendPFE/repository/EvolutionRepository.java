package com.example.BackendPFE.repository;

import com.example.BackendPFE.model.Evolution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvolutionRepository extends JpaRepository<Evolution, Long > {
}
