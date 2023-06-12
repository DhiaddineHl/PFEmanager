package com.dhia.pfemanager.pfemanager.authentication;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest registerRequest
    ){
        //
    };

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> Authenticate(
            @RequestBody AuthenticationRequest authenticationRequest
    ){
        //
    };

}
