package com.example.BackendPFE.repository;

import com.example.BackendPFE.model.Action;
import com.example.BackendPFE.model.Charge;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ActionRepository extends JpaRepository<Action,Long> {


  /*  List<Action> findByDemandeId(Long Id);

    @Transactional
    void deleteByDemandeId(Long demandeId);

    List<Acteur> findByActeurID(Long Id);

    @Transactional
    void deleteByActeurID(Integer acteurID);*/
}
