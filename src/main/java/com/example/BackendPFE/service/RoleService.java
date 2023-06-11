package com.example.BackendPFE.service;


import com.example.BackendPFE.model.Role;
import com.example.BackendPFE.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RoleService {
    private RoleRepository roleRepository;

    public Role createNewRole(Role role){
        return roleRepository.save(role);
    }

    public List<Role> getAllRoles(){
        List<Role> roleList = new ArrayList<>();
        roleRepository.findAll().forEach(roleList::add);
        return roleList;
    }
}
