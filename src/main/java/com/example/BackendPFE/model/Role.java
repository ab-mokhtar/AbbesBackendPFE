package com.example.BackendPFE.model;

import jakarta.persistence.*;
import lombok.Data;



@Entity
@Data
public class Role {
    @Id
    private String roleName;
    private String roleDescription;
}
