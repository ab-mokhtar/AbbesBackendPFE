package com.example.BackendPFE.controller;

import com.example.BackendPFE.exception.ResourceNotFoundException;
import com.example.BackendPFE.model.Amenagement;
import com.example.BackendPFE.model.AutresActivites;
import com.example.BackendPFE.repository.AmenagementRepository;
import com.example.BackendPFE.repository.AutresActivitesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/AutresActivites")
//@PreAuthorize("hasRole('ADMIN')")

public class AutresActivitesController {
    @Autowired
    AutresActivitesRepository autresActivitesRepository ;

    @GetMapping("/getAllAutresActivites")
    public List<AutresActivites> getAllAutresActivites() {
        return autresActivitesRepository.findAll();
    }


    @GetMapping("/getAutresActivitesById/{id}")
    public ResponseEntity<AutresActivites> getAutresActivitesById(@PathVariable("id") long id) throws ResourceNotFoundException {
        AutresActivites autresActivites = autresActivitesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found AutresActivites with id = " + id));

        return new ResponseEntity<>(autresActivites, HttpStatus.OK);
    }

    @PostMapping("/createAutresActivites")
    public AutresActivites createAutresActivites( @RequestBody AutresActivites autresActivites) {

        return autresActivitesRepository.save(autresActivites);
    }


    @PutMapping("/updateAutresActivites/{id}")
    public ResponseEntity<AutresActivites> updateAutresActivites(@PathVariable("id") long id, @RequestBody AutresActivites autresActivites) throws ResourceNotFoundException {
        AutresActivites _autresActivites = autresActivitesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found AutresActivites with id = " + id));

        _autresActivites.setObjetDemande(autresActivites.getObjetDemande());
        _autresActivites.setPlanifie(autresActivites.getPlanifie());
        _autresActivites.setOpportunite(autresActivites.getOpportunite());
        _autresActivites.setBu(autresActivites.getBu());
        _autresActivites.setResume(autresActivites.getResume());
        _autresActivites.setContexte(autresActivites.getContexte());
        _autresActivites.setAnticipation(autresActivites.getAnticipation());
        _autresActivites.setPhase(autresActivites.getPhase());
        _autresActivites.setDommaine(autresActivites.getDommaine());
        _autresActivites.setTechnologie(autresActivites.getTechnologie());
        _autresActivites.setTypeTrigramme(autresActivites.getTypeTrigramme());
        _autresActivites.setValeurTrigramme(autresActivites.getValeurTrigramme());
        _autresActivites.setStatut(autresActivites.getStatut());
        _autresActivites.setPriorite(autresActivites.getPriorite());
        _autresActivites.setDate(autresActivites.getDate());
        _autresActivites.setReference(autresActivites.getReference());
        _autresActivites.setCharge(autresActivites.getCharge());
        _autresActivites.setCommentaire(autresActivites.getCommentaire());
        _autresActivites.setClient(autresActivites.getClient());


        return new ResponseEntity<>(autresActivitesRepository.save(_autresActivites), HttpStatus.OK);
    }

    @DeleteMapping("/deleteAutresActivites/{id}")
    public ResponseEntity<HttpStatus> deleteAutresActivites(@PathVariable("id") long id) {
        autresActivitesRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/deleteAllAutresActivites")
    public ResponseEntity<HttpStatus> deleteAllAutresActivites() {
        autresActivitesRepository.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

