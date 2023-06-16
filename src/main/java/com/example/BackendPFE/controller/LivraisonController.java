package com.example.BackendPFE.controller;

import com.example.BackendPFE.exception.ResourceNotFoundException;
import com.example.BackendPFE.model.Livraison;
import com.example.BackendPFE.repository.LivraisonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("Livraison")
//@PreAuthorize("hasRole('MANAGER')")

public class LivraisonController {
    @Autowired
    LivraisonRepository livraisonRepository;


    @GetMapping("/getAllLivraison")
    public List<Livraison> getAllLivraison() {
        return livraisonRepository.findAll();
    }

    @GetMapping("/getLivraisonById/{id}")
    public ResponseEntity<Livraison> getLivraisonById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Livraison livraison = livraisonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Livraison not found for this id :: " + id));
        return ResponseEntity.ok().body(livraison);
    }

    @PostMapping("/createLivraison")
    public Livraison createLivraison( @RequestBody Livraison livraison) {

        return livraisonRepository.save(livraison);
    }

    @PutMapping("/updateLivraison/{id}")
    public ResponseEntity<Livraison> updateLivraison(@PathVariable("id") long id, @RequestBody Livraison livraison) throws ResourceNotFoundException {
        Livraison _Livraison = livraisonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Livraison with id = " + id));

        _Livraison.setVersionLivraison(livraison.getVersionLivraison());
        _Livraison.setTypeLivraison(livraison.getTypeLivraison());
        _Livraison.setFacturable(livraison.getFacturable());
        _Livraison.setRessourceLivraison(livraison.getRessourceLivraison());
        _Livraison.setDemande(livraison.getDemande());



        return new ResponseEntity<>(livraisonRepository.save(_Livraison), HttpStatus.OK);
    }

    @DeleteMapping("/deleteLivraison/{id}")
    public ResponseEntity<HttpStatus> deleteLivraison(@PathVariable("id") long id) {
        livraisonRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/deleteAllLivraison")
    public ResponseEntity<HttpStatus> deleteAllLivraison() {
        livraisonRepository.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

