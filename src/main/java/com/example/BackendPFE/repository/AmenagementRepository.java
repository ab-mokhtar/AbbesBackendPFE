package com.example.BackendPFE.repository;

import com.example.BackendPFE.model.Amenagement;
import com.example.BackendPFE.model.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmenagementRepository extends JpaRepository<Amenagement, Long > {


}
