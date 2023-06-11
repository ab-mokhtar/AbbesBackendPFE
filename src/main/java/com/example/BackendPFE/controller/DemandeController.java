package com.example.BackendPFE.controller;

import com.example.BackendPFE.exception.ResourceNotFoundException;
import com.example.BackendPFE.model.Date;
import com.example.BackendPFE.model.Demande;
import com.example.BackendPFE.repository.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Demande")
//@PreAuthorize("hasRole('ADMIN')")
@AllArgsConstructor
public class DemandeController {

    DemandeRepository demandeRepository;
    ReferenceRepository referenceRepository;
    ChargeRepository chargeRepository;
    DateRepository dateRepository;
    StatutRepository statutRepository;
    PrioriteRepository prioriteRepository;
    TypeDateRepository typeDateRepository;
    ClientRepository clientRepository;

    @GetMapping("/getAllDemandes")
    public ResponseEntity<List<Demande>> getAllDemandes() {


        return new ResponseEntity<>(demandeRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getDemandeById/{id}")
    public ResponseEntity<Demande> getDemandeById(@PathVariable("id") long id) throws ResourceNotFoundException {
        Demande demande = demandeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Demande with id = " + id));

        return new ResponseEntity<>(demande, HttpStatus.OK);
    }
    @PostMapping("/createDemande")
    public Demande createDemande(@Valid @RequestBody Demande demande) {
        // Set the reference
        demande.setReference(referenceRepository.findById(demande.getReference().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid reference ID")));

        // Set the charge
        demande.setCharge(chargeRepository.findById(demande.getCharge().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid charge ID")));

        // Set the statut
        demande.setStatut(statutRepository.findById(demande.getStatut().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid statut ID")));

        // Set the priorite
        demande.setPriorite(prioriteRepository.findById(demande.getPriorite().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid priorite ID")));
        // Set the priorite
        demande.setClient(clientRepository.findById(demande.getClient().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid client ID")));
        List<Date> dates = demande.getDate();
        List<Date> savedDates = new ArrayList<>();

        // Save the demande entity
        demande.setDate(null);
        Demande savedDemande = demandeRepository.save(demande);

        // Iterate through dates and save each one
        for (Date date : dates) {
            System.out.println(date.getTypeDate());
            date.setTypeDate(typeDateRepository.findById(date.getTypeDate().getId()).orElseThrow());
            date.setDemande(savedDemande);
            savedDates.add(dateRepository.save(date));
        }

        savedDemande.setDate(savedDates);
        return savedDemande;
    }

    /*@PostMapping("/createDemande")
    public ResponseEntity<Demande> createDemande(@RequestBody Demande demande) {
        Demande _demande = demandeRepository.save(
                new Demande(
                        demande.getObjetDemande(),
                        demande.getPlanifie(),
                        demande.getOpportunite(),
                        demande.getBu(),
                        demande.getResume(),
                        demande.getContexte(),
                        demande.getAnticipation(),
                        demande.getPhase(),
                        demande.getDommaine(),
                        demande.getTechnologie(),
                        demande.getTypeTrigramme(),
                        demande.getValeurTrigramme()
                      //  demande.getPlanning()

                        ));
        return new ResponseEntity<>(_demande, HttpStatus.CREATED);
    }*/

    @PutMapping("/updateDemande/{id}")
    public ResponseEntity<Demande> updateDemande(@PathVariable("id") long id, @RequestBody Demande demande) throws ResourceNotFoundException {
        Demande _demande = demandeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Demande with id = " + id));

        _demande.setObjetDemande(demande.getObjetDemande());
        _demande.setPlanifie(demande.getPlanifie());
        _demande.setOpportunite(demande.getOpportunite());
        _demande.setBu(demande.getBu());
        _demande.setResume(demande.getResume());
        _demande.setContexte(demande.getContexte());
        _demande.setAnticipation(demande.getAnticipation());
        _demande.setPhase(demande.getPhase());
        _demande.setDommaine(demande.getDommaine());
        _demande.setTechnologie(demande.getTechnologie());
        _demande.setTypeTrigramme(demande.getTypeTrigramme());
        _demande.setValeurTrigramme(demande.getValeurTrigramme());
        _demande.setStatut(demande.getStatut());
        _demande.setPriorite(demande.getPriorite());
        _demande.setReference(demande.getReference());
        _demande.setCharge(demande.getCharge());
        //_demande.setCommentaire(demande.getCommentaire());
        _demande.setClient(demande.getClient());
        for (Date d: demande.getDate()){
            d.setTypeDate(typeDateRepository.findById(d.getTypeDate().getId()).orElseThrow());
        }
        _demande.getDate().clear();
        _demande.getDate().addAll(demande.getDate());
        for (Date d: _demande.getDate()){
d.setDemande(_demande);
        }


        return new ResponseEntity<>(demandeRepository.save(_demande), HttpStatus.OK);
    }

    @DeleteMapping("/deleteDemande/{id}")
    public ResponseEntity<HttpStatus> deleteDemande(@PathVariable("id") long id) {
        demandeRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/deleteAllDemande")
    public ResponseEntity<HttpStatus> deleteAllDemande() {
        demandeRepository.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/nbrDemandes")
    public Long nbrDemandes(){
        return demandeRepository.count();
    }
    @GetMapping("/nbrDemandes/{statu}")
    public Long nbrDemandesByStatu(@PathVariable String statu){
        return demandeRepository.countByStatut_TypeStatut(statu);
    }
}
