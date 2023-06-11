package com.example.BackendPFE.controller;

import com.example.BackendPFE.exception.ResourceNotFoundException;
import com.example.BackendPFE.model.Reference;
import com.example.BackendPFE.repository.DemandeRepository;
import com.example.BackendPFE.repository.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
   // @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/api/v1/Reference")
    public class ReferenceController {

        @Autowired
        private ReferenceRepository referenceRepository  ;

        @Autowired
        private DemandeRepository demandeRepository;

        @GetMapping("/getAllReference")
        public ResponseEntity<List<Reference>> getAllReferences( )  {

            return new ResponseEntity<>(referenceRepository.findAll(), HttpStatus.OK);
        }

        @GetMapping("/getReferenceByDemandeId/{id}")
        public ResponseEntity<Reference> getChargeByDemandeId(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
            Reference reference = referenceRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Not found Reference with id = " + id));

            return new ResponseEntity<>(reference, HttpStatus.OK);
        }

        @PostMapping("/createReference")
        public ResponseEntity<Reference> createReference  (@RequestBody Reference reference)  {

            return new ResponseEntity<>(referenceRepository.save(reference), HttpStatus.CREATED);
        }

        @PutMapping("/updateReference/{id}")
        public ResponseEntity<Reference> updateReference(@PathVariable("id") long id, @RequestBody Reference ReferenceRequest) throws ResourceNotFoundException {
            Reference reference = referenceRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("CommentId " + id + "not found"));

            reference.setTypeReference(ReferenceRequest.getTypeReference());
            reference.setValeurReference(ReferenceRequest.getValeurReference());
            reference.setNoteReference(ReferenceRequest.getNoteReference());
            reference.setLienReference(ReferenceRequest.getLienReference());


            return new ResponseEntity<>(referenceRepository.save(reference), HttpStatus.OK);
        }

        @DeleteMapping("/deleteReference/{id}")
        public ResponseEntity<HttpStatus> deleteReference(@PathVariable("id") long id) {
            referenceRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        @DeleteMapping("/deleteAllReferencesOfDemande/{demandeId}")
        public ResponseEntity<List<Reference>> deleteAllReferencesOfDemande(@PathVariable(value = "demandeId") Long demandeId) throws ResourceNotFoundException {
            if (!demandeRepository.existsById(demandeId)) {
                throw new ResourceNotFoundException("Not found Demande with id = " + demandeId);
            }

            referenceRepository.deleteByDemandeId(demandeId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
