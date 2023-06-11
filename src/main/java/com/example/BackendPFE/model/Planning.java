package com.example.BackendPFE.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "planning")
public class Planning {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "planning_generator")
    private Long id;
    private Date debutPlanning ;
    private Date finPlanning ;
    private String Statut ;
/*    @OneToOne(mappedBy = "planning", cascade = CascadeType.ALL)
    private Demande demande;*/
}
