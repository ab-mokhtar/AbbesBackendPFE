package com.example.BackendPFE.controller;

import com.example.BackendPFE.exception.ResourceNotFoundException;
import com.example.BackendPFE.model.Livraison;
import com.example.BackendPFE.model.RessourceLivraison;
import com.example.BackendPFE.repository.LivraisonRepository;
import com.example.BackendPFE.repository.RessourceLivraisonRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("RessourceLivraison")
//@PreAuthorize("hasRole('MANAGER')")

public class RessourceLivraisonController {
    @Autowired
    RessourceLivraisonRepository ressourceLivraisonRepository;


    @GetMapping("/getAllRessourceLivraison")
    public List<RessourceLivraison> getAllRessourceLivraison() {
        return ressourceLivraisonRepository.findAll();
    }

    @GetMapping("/getRessourceLivraisonnById/{id}")
    public ResponseEntity<RessourceLivraison> getRessourceLivraisonById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        RessourceLivraison ressourceLivraison = ressourceLivraisonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RessourceLivraison not found for this id :: " + id));
        return ResponseEntity.ok().body(ressourceLivraison);
    }

    @PostMapping("/createRessourceLivraison")
    public RessourceLivraison createRessourceLivraison(@Valid @RequestBody RessourceLivraison ressourceLivraison) {

        return ressourceLivraisonRepository.save(ressourceLivraison);
    }

    /*@PutMapping("/updateRessourceLivraison/{id}")
    public ResponseEntity<RessourceLivraison> updateRessourceLivraison(@PathVariable("id") long id, @RequestBody RessourceLivraison ressourceLivraison) throws ResourceNotFoundException {
        RessourceLivraison _RessourceLivraison = ressourceLivraisonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found RessourceLivraison with id = " + id));

        _RessourceLivraison.set(livraison.getVersionLivraison());
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
    }*/

}
