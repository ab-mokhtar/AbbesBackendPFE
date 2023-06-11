package com.example.BackendPFE.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    public class Statut {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "date_generator")
        private Long id;
        private String typeStatut;
        private String valeurStatut;
        private String noteStatut;
   /* @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "demande_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Demande demande;*/
    @OneToMany(mappedBy = "statut")
    @JsonIgnore
    private List<Demande> demande ;

    }

