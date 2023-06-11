package com.example.BackendPFE.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/dev")
public class DevController {


    @GetMapping

    public String get() {
        return "GET:: dev controller";
    }
    @PostMapping

    public String post() {
        return "POST:: dev controller";
    }
    @PutMapping
    public String put() {
        return "PUT:: dev controller";
    }
    @DeleteMapping

    public String delete() {
        return "DELETE:: dev controller";
    }
}
