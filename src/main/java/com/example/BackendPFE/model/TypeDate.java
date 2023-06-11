package com.example.BackendPFE.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class TypeDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String type;
    private String hint;
    @OneToMany(mappedBy = "typeDate")
    @JsonIgnore
    private List<Date> date;
}
