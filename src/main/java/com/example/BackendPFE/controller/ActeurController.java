package com.example.BackendPFE.controller;

import com.example.BackendPFE.exception.ResourceNotFoundException;
import com.example.BackendPFE.model.User;
import com.example.BackendPFE.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
//@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/Acteur")
public class ActeurController {

UserRepository userRepository;


    @GetMapping("/getAllActeur")

    public List<User> getAllActeur() {
        return userRepository.findAll();
    }
/*
    @GetMapping("/getActeurById/{id}")
    public ResponseEntity<Acteur> getActeurById(@PathVariable(value = "id") Integer acteurId)
            throws ResourceNotFoundException {
        Acteur acteur = userRepository.findById(acteurId)
                .orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " + acteurId));
        return ResponseEntity.ok().body(acteur);
    }

  @PostMapping("/createActeur")
    public Acteur createActeur(@Valid @RequestBody Acteur acteur) {

        return userRepository.save(acteur);
    }

    @DeleteMapping("/deleteActeur/{id}")
    public Map<String, Boolean> deleteActeur(@PathVariable(value = "id") Integer acteurId)
            throws ResourceNotFoundException {
        Acteur acteur = userRepository.findById(acteurId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not present for the id :: " + acteurId));

        userRepository.delete(acteur);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    @PutMapping("/updateActeur/{id}")
    public ResponseEntity<Acteur> updateActeur(@PathVariable(value = "id") Integer acteurId,
    @Valid @RequestBody Acteur UserDetails) throws    ResourceNotFoundException {
        Acteur acteur = userRepository.findById(acteurId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + acteurId));

        acteur.setMail(UserDetails.getMail());
        acteur.setNom(UserDetails.getNom());
        acteur.setPrenom(UserDetails.getPrenom());
        acteur.setRole(UserDetails.getRole());
        final Acteur updatedActeur = userRepository.save(acteur);
        return ResponseEntity.ok(updatedActeur);
    }
*/
}
