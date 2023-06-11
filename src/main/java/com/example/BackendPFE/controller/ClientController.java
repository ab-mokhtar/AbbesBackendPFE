package com.example.BackendPFE.controller;

import com.example.BackendPFE.model.Client;
import com.example.BackendPFE.model.Demande;
import com.example.BackendPFE.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Client")
@AllArgsConstructor
public class ClientController {
    ClientRepository clientRepository;
    @GetMapping("/getAlls")
    List<Client> getAllClient(){
        return clientRepository.findAll();
    }
    @GetMapping("/getClient/{id}")
    Client getClientById(@PathVariable Long id){
        return clientRepository.findById(id).orElseThrow();
    }
    @PostMapping("/create")
    public Client createClient(@RequestBody Client cl){
        return clientRepository.save(cl);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){


        clientRepository.deleteById(id);
    }

}
