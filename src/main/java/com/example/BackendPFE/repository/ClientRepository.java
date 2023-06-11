package com.example.BackendPFE.repository;

import com.example.BackendPFE.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
