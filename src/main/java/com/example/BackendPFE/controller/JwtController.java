package com.example.BackendPFE.controller;


import com.example.BackendPFE.model.JwtRequest;
import com.example.BackendPFE.model.JwtResponse;
import com.example.BackendPFE.repository.UserRepository;
import com.example.BackendPFE.service.EmailSenderService;
import com.example.BackendPFE.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JwtController {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private EmailSenderService emailSenderService;
    @Autowired
    private UserRepository userRepository;

    //this will take userName and password and will return jwt token if the user is valid
    @PostMapping("/authenticate")
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest)throws Exception{
        return jwtService.createJwtToken(jwtRequest);
    }
    @PostMapping("/mdpoub")
    public ResponseEntity resetmpd(@RequestBody String email){

        if(userRepository.findById(email).isPresent()){
        try {
             emailSenderService.sendmail(email);
            return new ResponseEntity(HttpStatus.OK);

        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);

        }}
        else   return new ResponseEntity(HttpStatus.CREATED);


    }
}
