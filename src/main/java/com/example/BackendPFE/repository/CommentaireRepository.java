package com.example.BackendPFE.repository;

import com.example.BackendPFE.model.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
    List<Commentaire> findByDemandeId(Long Id);

    @Transactional
    void deleteByDemandeId(long DemandeId);
}
