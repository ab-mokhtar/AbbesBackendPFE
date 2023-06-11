package com.example.BackendPFE.controller;


import com.example.BackendPFE.exception.ResourceNotFoundException;
import com.example.BackendPFE.model.Action;
import com.example.BackendPFE.repository.ActionRepository;
import com.example.BackendPFE.repository.DemandeRepository;
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
//@PreAuthorize( "hasRole('DEV','MANAGER')")
@RequestMapping("/api/v1/Action")
public class ActionController {
    private ActionRepository actionRepository;
    private UserRepository userRepository;
    private DemandeRepository demandeRepository;


    @GetMapping("/getAllAction")
    public List<Action> getAllAction() {
        return actionRepository.findAll();
    }

    @GetMapping("/getActionById/{id}")
    public ResponseEntity<Action> getActionById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Action action = actionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " + id));
        return ResponseEntity.ok().body(action);
    }

    @PostMapping("/createAction")
    public Action createAction( @RequestBody Action action) {
        System.out.println(action.getUser().getUserEmail());

        action.setUser(userRepository.findById(action.getUser().getUserEmail()).orElseThrow());
        action.setDemande(demandeRepository.findById(action.getDemande().getId()).orElseThrow());
        return actionRepository.save(action);
    }



    @DeleteMapping("/deleteAction/{id}")
    public Map<String, Boolean> deleteAction(@PathVariable(value = "id") Long id )
            throws ResourceNotFoundException {
        Action action = actionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Action not present for the id :: " + id));

        actionRepository.delete(action);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    @PutMapping("/updateAction/{id}")
    public ResponseEntity<Action> updateAction(@PathVariable(value = "id") Long id,
                                               @Valid @RequestBody Action ActionDetails) throws    ResourceNotFoundException {
        Action action = actionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Action not found for this id :: " + id));

        action.setDescriptionAction(ActionDetails.getDescriptionAction());
        action.setProchainAction(ActionDetails.getProchainAction());
        action.setUser(ActionDetails.getUser());
        final Action updatedAction = actionRepository.save(action);
        return ResponseEntity.ok(updatedAction);
    }
    @GetMapping("/nbrActions")
    public Long nbrActions(){
        return actionRepository.count();
    }

}
