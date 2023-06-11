package com.example.BackendPFE.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teamleadr")
public class TeamLeadrController {


        @GetMapping

        public String get() {
            return "GET:: teamleadr controller";
        }
        @PostMapping

        public String post() {
            return "POST:: teamleadr controller";
        }
        @PutMapping
        public String put() {
            return "PUT:: teamleadr controller";
        }
        @DeleteMapping

        public String delete() {
            return "DELETE:: teamleadr controller";
        }
    }
