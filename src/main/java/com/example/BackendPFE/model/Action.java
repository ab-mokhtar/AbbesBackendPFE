package com.example.BackendPFE.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "date_generator")
    private Long id;
    private String descriptionAction;
    private String prochainAction;
    @ManyToOne
    @JoinColumn(name = "demande_id", nullable = false)
    private Demande demande;
    @ManyToOne
    @JoinColumn(name = "acteur_id", nullable = false)
    private User user;

@Enumerated(EnumType.STRING)
private  PrioriteFiliere prioriteFiliere;

    @Enumerated(EnumType.STRING)
    private Engagement engagement;
    private LocalDate debutAction ;
    private LocalDate finAction ;
}
