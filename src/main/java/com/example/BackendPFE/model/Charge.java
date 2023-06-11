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
public class Charge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "charge_generator")
    private Long id;
    private String typeCharge;
    private float valeurCharge;

    @OneToMany
    @JsonIgnore
    private List<Demande> demande;

}
