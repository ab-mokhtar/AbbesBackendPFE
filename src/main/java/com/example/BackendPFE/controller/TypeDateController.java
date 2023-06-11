package com.example.BackendPFE.controller;

import com.example.BackendPFE.model.TypeDate;
import com.example.BackendPFE.repository.TypeDateRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/TypeDate")

public class TypeDateController {
    TypeDateRepository typeDateRepository;
    @GetMapping("/getAlls")
    public List<TypeDate>getAll(){
        return  typeDateRepository.findAll();
    }
    @PostMapping("/save")
    public TypeDate addType(@RequestBody TypeDate typeDate){
        return typeDateRepository.save(typeDate);
    }
    @PutMapping("/update/{id}")
    public TypeDate updateType(@PathVariable Long id,@RequestBody TypeDate updated){

        TypeDate old=typeDateRepository.findById(id).orElseThrow();
        old.setHint(updated.getHint());
        old.setType(updated.getType());
        return typeDateRepository.save(old);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> addType(@PathVariable Long id){

        TypeDate old=typeDateRepository.findById(id).orElseThrow();
         typeDateRepository.delete(old);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
