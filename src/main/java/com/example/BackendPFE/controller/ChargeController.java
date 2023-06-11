package com.example.BackendPFE.controller;

import com.example.BackendPFE.exception.ResourceNotFoundException;
import com.example.BackendPFE.model.Charge;
import com.example.BackendPFE.model.Demande;
import com.example.BackendPFE.repository.ChargeRepository;
import com.example.BackendPFE.repository.DemandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/api/v1/Charge")
    public class ChargeController {

        @Autowired
        private ChargeRepository chargeRepository ;

        @Autowired
        private DemandeRepository demandeRepository;

        @GetMapping("/getAllCharge")
        public ResponseEntity<List<Charge>> getAllChargeByDemandeId()  {

            return new ResponseEntity<>(chargeRepository.findAll(), HttpStatus.OK);
        }

        @GetMapping("/getChargeByDemandeId/{id}")
        public ResponseEntity<Charge> getChargeByDemandeId(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
            Charge comment = chargeRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Not found charge with id = " + id));

            return new ResponseEntity<>(comment, HttpStatus.OK);
        }

        @PostMapping("/createCharge")
        public ResponseEntity<Charge> createCharge
                (@RequestBody Charge chargeRequest) {

            return new ResponseEntity<>(chargeRepository.save(chargeRequest), HttpStatus.CREATED);
        }

        @PutMapping("/updateCharge/{id}")
        public ResponseEntity<Charge> updateCharge(@PathVariable("id") long id, @RequestBody Charge chargeRequest) throws ResourceNotFoundException {
            Charge charge = chargeRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("CommentId " + id + "not found"));

            charge.setTypeCharge(chargeRequest.getTypeCharge());
            charge.setValeurCharge(chargeRequest.getValeurCharge());

            return new ResponseEntity<>(chargeRepository.save(charge), HttpStatus.OK);
        }

        @DeleteMapping("/deleteCharge/{id}")
        public ResponseEntity<HttpStatus> deleteCharge(@PathVariable("id") long id) {
            chargeRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        @DeleteMapping("/deleteAllChargesOfDemande/{demandeId}")
        public ResponseEntity<List<Charge>> deleteAllChargesOfDemande(@PathVariable(value = "demandeId") Long demandeId) throws ResourceNotFoundException {
            if (!demandeRepository.existsById(demandeId)) {
                throw new ResourceNotFoundException("Not found Demande with id = " + demandeId);
            }

            chargeRepository.deleteByDemandeId(demandeId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
