package com.example.BackendPFE.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

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
    private LocalDate date ;

    private String description ;
    @ManyToMany
    private List<User> users;

}
