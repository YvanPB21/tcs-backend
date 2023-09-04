package com.example.tata.controllers;

import com.example.tata.controllers.requests.AuthRequest;
import com.example.tata.controllers.responses.AuthResponse;
import com.example.tata.exception.CustomException;
import com.example.tata.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/authenticate")
    public ResponseEntity<?> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new CustomException("Invalid username/password");
        }
        AuthResponse auth = new AuthResponse();
        auth.setToken(jwtUtil.generateToken(authRequest.getUserName()));
        return  ResponseEntity.ok(auth) ;
    }
}
