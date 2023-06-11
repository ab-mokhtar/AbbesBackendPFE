package com.example.BackendPFE.controller;

import com.example.BackendPFE.exception.ResourceNotFoundException;
import com.example.BackendPFE.model.Demande;
import com.example.BackendPFE.model.Statut;
import com.example.BackendPFE.repository.DemandeRepository;
import com.example.BackendPFE.repository.StatutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    //@PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/api/v1/Statut")
    public class StatutController {

        @Autowired
        private StatutRepository statutRepository  ;

        @Autowired
        private DemandeRepository demandeRepository;

        @GetMapping("/getAllStatuts")
        public ResponseEntity<List<Statut>> getAllStatuts()  {

            return new ResponseEntity<>(statutRepository.findAll(), HttpStatus.OK);
        }

        @GetMapping("/getStatutByDemandeId/{id}")
        public ResponseEntity<Statut> getStatutByDemandeId(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
            Statut statut = statutRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Not found Statut with id = " + id));

            return new ResponseEntity<>(statut, HttpStatus.OK);
        }

        @PostMapping("/createStatut")
        public ResponseEntity<Statut> createStatut  (@RequestBody Statut StatutRequest)  {

            return new ResponseEntity<>(statutRepository.save(StatutRequest), HttpStatus.CREATED);
        }

        @PutMapping("/updateStatut/{id}")
        public ResponseEntity<Statut> updateStatut(@PathVariable("id") long id, @RequestBody Statut StatutRequest) throws ResourceNotFoundException {
            Statut statut = statutRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("CommentId " + id + "not found"));

            statut.setTypeStatut(StatutRequest.getTypeStatut());
            statut.setValeurStatut(StatutRequest.getValeurStatut());
            statut.setNoteStatut(StatutRequest.getNoteStatut());



            return new ResponseEntity<>(statutRepository.save(statut), HttpStatus.OK);
        }

        @DeleteMapping("/deleteStatut/{id}")
        public ResponseEntity<HttpStatus> deleteStatut(@PathVariable("id") long id) {
            statutRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        @DeleteMapping("/deleteAllStatutsOfDemande/{demandeId}")
        public ResponseEntity<List<Statut>> deleteAllStatutsOfDemande(@PathVariable(value = "demandeId") Long demandeId) throws ResourceNotFoundException {
            if (!demandeRepository.existsById(demandeId)) {
                throw new ResourceNotFoundException("Not found Demande with id = " + demandeId);
            }

            statutRepository.deleteByDemandeId(demandeId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

