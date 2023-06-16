package com.example.BackendPFE.controller;

import com.example.BackendPFE.exception.ResourceNotFoundException;
import com.example.BackendPFE.model.Amenagement;
import com.example.BackendPFE.model.Evolution;
import com.example.BackendPFE.repository.AmenagementRepository;
import com.example.BackendPFE.repository.EvolutionRepository;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Evolution")
//@PreAuthorize("hasRole('ADMIN')")

public class EvolutionController {
    @Autowired
    EvolutionRepository evolutionRepository;

    @GetMapping("/getAllEvolution")
    public List<Evolution> getAllEvolution() {
        return evolutionRepository.findAll();
    }


    @GetMapping("/getEvolutionById/{id}")
    public ResponseEntity<Evolution> getEvolutionById(@PathVariable("id") long id) throws ResourceNotFoundException {
        Evolution evolution = evolutionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Evolution with id = " + id));

        return new ResponseEntity<>(evolution, HttpStatus.OK);
    }

    @PostMapping("/createEvolution")
    public Evolution createEvolution( @RequestBody Evolution evolution) {

        return evolutionRepository.save(evolution);
    }


    @PutMapping("/updateEvolution/{id}")
    public ResponseEntity<Evolution> updateEvolution(@PathVariable("id") long id, @RequestBody Evolution evolution) throws ResourceNotFoundException {
        Evolution _evolution = evolutionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Evolution with id = " + id));

        _evolution.setObjetDemande(evolution.getObjetDemande());
        _evolution.setPlanifie(evolution.getPlanifie());
        _evolution.setOpportunite(evolution.getOpportunite());
        _evolution.setBu(evolution.getBu());
        _evolution.setResume(evolution.getResume());
        _evolution.setContexte(evolution.getContexte());
        _evolution.setAnticipation(evolution.getAnticipation());
        _evolution.setPhase(evolution.getPhase());
        _evolution.setDommaine(evolution.getDommaine());
        _evolution.setTechnologie(evolution.getTechnologie());
        _evolution.setTypeTrigramme(evolution.getTypeTrigramme());
        _evolution.setValeurTrigramme(evolution.getValeurTrigramme());
        _evolution.setStatut(evolution.getStatut());
        _evolution.setPriorite(evolution.getPriorite());
        _evolution.setDate(evolution.getDate());
        _evolution.setReference(evolution.getReference());
        _evolution.setCharge(evolution.getCharge());
        _evolution.setCommentaire(evolution.getCommentaire());
        _evolution.setClient(evolution.getClient());


        return new ResponseEntity<>(evolutionRepository.save(_evolution), HttpStatus.OK);
    }

    @DeleteMapping("/deleteEvolution/{id}")
    public ResponseEntity<HttpStatus> deleteEvolution(@PathVariable("id") long id) {
        evolutionRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/deleteAllEvolution")
    public ResponseEntity<HttpStatus> deleteAllEvolution() {
        evolutionRepository.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

