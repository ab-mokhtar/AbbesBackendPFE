package com.example.BackendPFE.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DetailPlanning {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "demande_generator")
   private long id;
    private String type;

    @Enumerated(EnumType.STRING)
    private Seniorite seniorite;
    private String bU;
    private String activite;

    @Enumerated(EnumType.STRING)
    private Engagement engagement;
    private String opportunite;
  /*  @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "demande_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Planning planning;*/

/*    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "acteur_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Acteur acteur;*/
}