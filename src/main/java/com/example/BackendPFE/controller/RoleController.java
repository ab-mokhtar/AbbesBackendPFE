package com.example.BackendPFE.controller;

import com.example.BackendPFE.model.Role;
import com.example.BackendPFE.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role")

public class RoleController {

    @Autowired
    private RoleService roleService;
    @PostMapping("/createNewRole")
    public Role createNewRole(@RequestBody Role role){
        return  roleService.createNewRole(role);
    }

    @GetMapping("/getall")
    public List<Role> getRoles(){
        return roleService.getAllRoles();
    }
}
