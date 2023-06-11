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
public class RessourceLivraison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ressourceLivraison_generator")
    private Long id;
    private String typeRessource;
    private String typeLivrable;
    private String tag;
    private String nomRessource;
    private String repertoire;
    private  String libelle;
/*    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "livraison_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Livraison livraison;*/

    @OneToMany(mappedBy = "ressourceLivraison")
    private List<Livraison> livraisons;

}
