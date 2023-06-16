package com.example.BackendPFE.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    public class Date {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "date_generator")
        private Long id;
        @ManyToOne
        private TypeDate typeDate;
    private LocalDate valeurDate;

       /* @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "demande_id", nullable = false)
        @OnDelete(action = OnDeleteAction.CASCADE)
        @JsonIgnore
        private Demande demande;*/
       @ManyToOne
       @JsonIgnore
       private Demande demande ;

    public void setValeurDate(String valeurDate) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate localDate = LocalDate.parse(valeurDate, formatter);
            this.valeurDate = localDate;
        }
        catch (Exception e){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(valeurDate, formatter);
            this.valeurDate = localDate;
        }
    }



}
