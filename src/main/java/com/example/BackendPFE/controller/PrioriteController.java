package com.example.BackendPFE.controller;

import com.example.BackendPFE.exception.ResourceNotFoundException;
import com.example.BackendPFE.model.Demande;
import com.example.BackendPFE.model.Priorite;
import com.example.BackendPFE.repository.DemandeRepository;
import com.example.BackendPFE.repository.PrioriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    //@PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/api/v1/Priorite")
    public class PrioriteController {

        @Autowired
        private PrioriteRepository prioriteRepository ;

        @Autowired
        private DemandeRepository demandeRepository;

        @GetMapping("/getAllPriorites")
        public ResponseEntity<List<Priorite>> getAllPriorite()  {

            return new ResponseEntity<>(prioriteRepository.findAll(), HttpStatus.OK);
        }

        @GetMapping("/getPrioriteByDemandeId/{id}")
        public ResponseEntity<Priorite> getPrioriteByDemandeId(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
            Priorite priorite = prioriteRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Not found Priorite with id = " + id));

            return new ResponseEntity<>(priorite, HttpStatus.OK);
        }

        @PostMapping("/createPriorite")
        public ResponseEntity<Priorite> createPriorite  (@RequestBody Priorite PrioriteRequest)  {


            return new ResponseEntity<>(prioriteRepository.save(PrioriteRequest), HttpStatus.CREATED);
        }

        @PutMapping("/updatePriorite/{id}")
        public ResponseEntity<Priorite> updatePriorite(@PathVariable("id") long id, @RequestBody Priorite PrioriteRequest) throws ResourceNotFoundException {
            Priorite priorite = prioriteRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("CommentId " + id + "not found"));

            priorite.setTypePriorite(PrioriteRequest.getTypePriorite());
            priorite.setValeurPriorite(PrioriteRequest.getValeurPriorite());

            return new ResponseEntity<>(prioriteRepository.save(priorite), HttpStatus.OK);
        }

        @DeleteMapping("/deletePriorite/{id}")
        public ResponseEntity<HttpStatus> deletePriorite(@PathVariable("id") long id) {
            prioriteRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        @DeleteMapping("/deleteAllPrioritesOfDemande/{demandeId}")
        public ResponseEntity<List<Priorite>> deleteAllPrioritesOfDemande(@PathVariable(value = "demandeId") Long demandeId) throws ResourceNotFoundException {
            if (!demandeRepository.existsById(demandeId)) {
                throw new ResourceNotFoundException("Not found Demande with id = " + demandeId);
            }

            prioriteRepository.deleteByDemandeId(demandeId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

