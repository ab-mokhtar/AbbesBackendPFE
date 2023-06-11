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
@Table(name = "demande")
public class Demande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "demande_generator")
    private long id;
    private String objetDemande;
    private String planifie;
    private String opportunite;
    private String bu;
    private String resume;
    private String contexte;
    private String anticipation;
    private String phase;
    private  String dommaine;
    private  String technologie;
    private  String typeTrigramme;
    private  String valeurTrigramme;


   /* @OneToOne(optional = false)
    @JoinColumn(name = "planning_id", referencedColumnName = "id")
    private Planning planning;*/
   /*@OneToMany(mappedBy = "demande")
   private List<Statut> statuts;*/
    @ManyToOne
    private Charge charge;

    @ManyToOne
    private Reference reference;
    @ManyToOne
    @JoinColumn(name = "priorite_id", nullable = false)
    private Priorite priorite;

    @OneToMany(mappedBy = "demande", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Date> date;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Commentaire> commentaire;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", nullable = true)
    private Client client;
    @ManyToOne
    @JoinColumn(name = "statut_id", nullable = false)
    private Statut statut;
   /* @OneToMany(mappedBy = "demande")
    private List<Reference> references;
    @OneToMany(mappedBy = "demande")
    private List<Priorite> priorites;

  *//*  @OneToMany(mappedBy = "demande")
    private List<Charge> charges;*//*

    @OneToMany(mappedBy = "demande")
    private List<Date> dates;

    @OneToMany(mappedBy = "demande")
    private List<Commentaire> commentaires;
    @OneToMany(mappedBy = "demande")
    private List<Client> clients;*/
   public void addDate(Date date) {
       this.date.add(date);
       date.setDemande(this);
   }

    public void removeDate(Date date) {
        this.date.remove(date);
        date.setDemande(null);
    }
}
