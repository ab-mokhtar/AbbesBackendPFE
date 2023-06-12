package com.example.BackendPFE.service;

import com.example.BackendPFE.model.Planning;
import com.example.BackendPFE.repository.PlanningRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlanningService {
    PlanningRepository planningRepository;
    public List<Planning> getALls(){
        return planningRepository.findAll();
    }
    public Planning createPlanning(Planning p){
        return planningRepository.save(p);
    }

}
