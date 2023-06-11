package com.example.BackendPFE.controller;

import com.example.BackendPFE.exception.ResourceNotFoundException;
import com.example.BackendPFE.model.Maintenance;
import com.example.BackendPFE.repository.MaintenanceRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api/v1/Maintenance")
    //@PreAuthorize("hasRole('MANAGER')")

    public class MaintenanceController {
        @Autowired
        MaintenanceRepository maintenanceRepository;


        @GetMapping("/getAllMaintenance")
        public List<Maintenance> getAllMaintenance() {
            return maintenanceRepository.findAll();
        }

        @GetMapping("/getMaintenanceById/{id}")
        public ResponseEntity<Maintenance> getMaintenanceById(@PathVariable(value = "id") Long id)
                throws ResourceNotFoundException {
            Maintenance maintenance = maintenanceRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " + id));
            return ResponseEntity.ok().body(maintenance);
        }

        @PostMapping("/createMaintenance")
        public Maintenance createMaintenance(@Valid @RequestBody Maintenance maintenance) {

            return maintenanceRepository.save(maintenance);
        }

        @PutMapping("/updateMaintenance/{id}")
        public ResponseEntity<Maintenance> updateMaintenance(@PathVariable("id") long id, @RequestBody Maintenance maintenance) throws ResourceNotFoundException {
            Maintenance _Maintenance = maintenanceRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Not found Maintenance with id = " + id));

            _Maintenance.setObjetDemande(maintenance.getObjetDemande());
            _Maintenance.setPlanifie(maintenance.getPlanifie());
            _Maintenance.setOpportunite(maintenance.getOpportunite());
            _Maintenance.setBu(maintenance.getBu());
            _Maintenance.setResume(maintenance.getResume());
            _Maintenance.setContexte(maintenance.getContexte());
            _Maintenance.setAnticipation(maintenance.getAnticipation());
            _Maintenance.setPhase(maintenance.getPhase());
            _Maintenance.setDommaine(maintenance.getDommaine());
            _Maintenance.setTechnologie(maintenance.getTechnologie());
            _Maintenance.setTypeTrigramme(maintenance.getTypeTrigramme());
            _Maintenance.setValeurTrigramme(maintenance.getValeurTrigramme());
            _Maintenance.setStatut(maintenance.getStatut());
            _Maintenance.setPriorite(maintenance.getPriorite());
            _Maintenance.setDate(maintenance.getDate());
            _Maintenance.setReference(maintenance.getReference());
            _Maintenance.setCharge(maintenance.getCharge());
            _Maintenance.setCommentaire(maintenance.getCommentaire());
            _Maintenance.setClient(maintenance.getClient());



            return new ResponseEntity<>(maintenanceRepository.save(_Maintenance), HttpStatus.OK);
        }

        @DeleteMapping("/deleteMaintenance/{id}")
        public ResponseEntity<HttpStatus> deleteMaintenance(@PathVariable("id") long id) {
            maintenanceRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        @DeleteMapping("/deleteAllMaintenance")
        public ResponseEntity<HttpStatus> deleteAllMaintenance() {
            maintenanceRepository.deleteAll();

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

