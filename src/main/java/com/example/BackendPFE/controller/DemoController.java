package com.example.BackendPFE.controller;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo-controller")
public class DemoController {

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello from secured endpoint");
    }
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    //@PreAuthorize("hasRole('DEV') or hasRole('MANAGER') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/mod")
    //@PreAuthorize("hasRole('MANAGER')")
    public String moderatorAccess() {
        return "MANAGER Board.";
    }

    @GetMapping("/admin")
    //@PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }

}
