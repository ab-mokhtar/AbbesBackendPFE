package com.example.BackendPFE.model;

import lombok.Data;

@Data
public class JwtRequest {
    private String userName;
    private String userPassword;

}
