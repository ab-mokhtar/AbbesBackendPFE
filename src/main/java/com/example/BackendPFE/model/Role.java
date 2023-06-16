package com.example.BackendPFE.model;

import javax.persistence.*;
import lombok.Data;



@Entity
@Data
public class Role {
    @Id
    private String roleName;
    private String roleDescription;
}
