package com.example.BackendPFE.controller;

import com.example.BackendPFE.exception.ResourceNotFoundException;
import com.example.BackendPFE.model.Amenagement;
import com.example.BackendPFE.repository.AmenagementRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Amenagement")
//@PreAuthorize("hasRole('ADMIN')")

public class AmenagementController {
    @Autowired
    AmenagementRepository amenagementRepository ;

    @GetMapping("/getAllAmenagements")
    public List<Amenagement> getAllAmenagements() {
        return amenagementRepository.findAll();
    }


    @GetMapping("/getAmenagementById/{id}")
    public ResponseEntity<Amenagement> getAmenagementById(@PathVariable("id") long id) throws ResourceNotFoundException {
        Amenagement amenagement = amenagementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Amenagement with id = " + id));

        return new ResponseEntity<>(amenagement, HttpStatus.OK);
    }

    @PostMapping("/createAmenagement")
    public Amenagement createAmenagement( @RequestBody Amenagement amenagement) {

        return amenagementRepository.save(amenagement);
    }


    @PutMapping("/updateAmenagement/{id}")
    public ResponseEntity<Amenagement> updateAmenagement(@PathVariable("id") long id, @RequestBody Amenagement amenagement) throws ResourceNotFoundException {
        Amenagement _amenagement = amenagementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Amenagement with id = " + id));

        _amenagement.setObjetDemande(amenagement.getObjetDemande());
        _amenagement.setPlanifie(amenagement.getPlanifie());
        _amenagement.setOpportunite(amenagement.getOpportunite());
        _amenagement.setBu(amenagement.getBu());
        _amenagement.setResume(amenagement.getResume());
        _amenagement.setContexte(amenagement.getContexte());
        _amenagement.setAnticipation(amenagement.getAnticipation());
        _amenagement.setPhase(amenagement.getPhase());
        _amenagement.setDommaine(amenagement.getDommaine());
        _amenagement.setTechnologie(amenagement.getTechnologie());
        _amenagement.setTypeTrigramme(amenagement.getTypeTrigramme());
        _amenagement.setValeurTrigramme(amenagement.getValeurTrigramme());
        _amenagement.setStatut(amenagement.getStatut());
        _amenagement.setPriorite(amenagement.getPriorite());
        _amenagement.setDate(amenagement.getDate());
        _amenagement.setReference(amenagement.getReference());
        _amenagement.setCharge(amenagement.getCharge());
        _amenagement.setCommentaire(amenagement.getCommentaire());
        _amenagement.setClient(amenagement.getClient());


        return new ResponseEntity<>(amenagementRepository.save(_amenagement), HttpStatus.OK);
    }

    @DeleteMapping("/deleteAmenagement/{id}")
    public ResponseEntity<HttpStatus> deleteAmenagement(@PathVariable("id") long id) {
        amenagementRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/deleteAllAmenagement")
    public ResponseEntity<HttpStatus> deleteAllAmenagement() {
        amenagementRepository.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
