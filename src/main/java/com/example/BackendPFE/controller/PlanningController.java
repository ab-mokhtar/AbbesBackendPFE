package com.example.BackendPFE.controller;

import com.example.BackendPFE.model.Planning;
import com.example.BackendPFE.model.User;
import com.example.BackendPFE.repository.UserRepository;
import com.example.BackendPFE.service.PlanningService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/Planning")
public class PlanningController {
    PlanningService planningService;
    UserRepository userRepository;
    @GetMapping("/getAll")
    public List<Planning> getAllPlannings() {
        return planningService.getALls();
    }
    @PostMapping("/create")
    public Planning createPlanning( @RequestBody Planning pla) {
        List<User> list=pla.getUsers();
        List<User> l2=new ArrayList<>();
        for (User u:list) {
            l2.add(userRepository.findById(u.getUserEmail()).orElseThrow());
        }
      pla.setUsers(l2);
        return planningService.createPlanning(pla);
    }

}
