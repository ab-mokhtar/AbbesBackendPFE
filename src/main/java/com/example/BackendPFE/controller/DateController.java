package com.example.BackendPFE.controller;

import com.example.BackendPFE.exception.ResourceNotFoundException;
import com.example.BackendPFE.model.Date;
import com.example.BackendPFE.model.Demande;
import com.example.BackendPFE.repository.DateRepository;
import com.example.BackendPFE.repository.DemandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    //@PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/api/v1/Date")
    public class DateController {

        @Autowired
        private DateRepository dateRepository  ;

        @Autowired
        private DemandeRepository demandeRepository;

        @GetMapping("/getAllDateByDemandeId/{demandeId}")
        public ResponseEntity<List<Date>> getAllDateByDemandeId(@PathVariable(value = "demandeId") Long demandeId) throws ResourceNotFoundException {
            if (!demandeRepository.existsById(demandeId)) {
                throw new ResourceNotFoundException("Not found demande with id = " + demandeId);
            }

            List<Date> dates = dateRepository.findByDemandeId(demandeId);
            return new ResponseEntity<>(dates, HttpStatus.OK);
        }

        @GetMapping("/getDateByDemandeId/{id}")
        public ResponseEntity<Date> getDateByDemandeId(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
            Date date = dateRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Not found Date with id = " + id));

            return new ResponseEntity<>(date, HttpStatus.OK);
        }

        @PostMapping("/createDate/{demandeId}")
        public ResponseEntity<Date> createDate (@PathVariable(value = "demandeId") Long demandeId,
                                                     @RequestBody Date DateRequest) throws ResourceNotFoundException {
            Date date = demandeRepository.findById(demandeId).map(demande -> {
                DateRequest.setDemande(demande);
                return dateRepository.save(DateRequest);
            }).orElseThrow(() -> new ResourceNotFoundException("Not found demande with id = " + demandeId));

            return new ResponseEntity<>(date, HttpStatus.CREATED);
        }

        @PutMapping("/updateDate/{id}")
        public ResponseEntity<Date> updateDate(@PathVariable("id") long id, @RequestBody Date DateRequest) throws ResourceNotFoundException {
            Date date = dateRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("CommentId " + id + "not found"));

            date.setTypeDate(DateRequest.getTypeDate());
            date.setValeurDate(DateRequest.getValeurDate().toString());


            return new ResponseEntity<>(dateRepository.save(date), HttpStatus.OK);
        }

        @DeleteMapping("/deleteDate/{id}")
        public ResponseEntity<HttpStatus> deleteDate(@PathVariable("id") long id) {
            dateRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        @DeleteMapping("/deleteAllDatesOfDemande/{demandeId}")
        public ResponseEntity<List<Date>> deleteAllDatesOfDemande(@PathVariable(value = "demandeId") Long demandeId) throws ResourceNotFoundException {
            if (!demandeRepository.existsById(demandeId)) {
                throw new ResourceNotFoundException("Not found Demande with id = " + demandeId);
            }

            dateRepository.deleteByDemandeId(demandeId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

