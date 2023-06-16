package com.example.BackendPFE.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
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
public class Priorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "priorite_generator")
    private Long id;
    private String typePriorite;
    private String valeurPriorite;
  /*  @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "demande_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Demande demande;*/

    @OneToMany(mappedBy = "priorite")
    @JsonIgnore
    private List<Demande> demande ;
}

