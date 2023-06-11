package com.example.BackendPFE.repository;

import com.example.BackendPFE.model.Commentaire;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
    List<Commentaire> findByDemandeId(Long Id);

    @Transactional
    void deleteByDemandeId(long DemandeId);
}
