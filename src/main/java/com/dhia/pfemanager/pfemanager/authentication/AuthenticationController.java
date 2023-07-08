package com.dhia.pfemanager.pfemanager.authentication;


import com.dhia.pfemanager.pfemanager.authentication.requests.*;
import com.dhia.pfemanager.pfemanager.user.exceptions.EmailTakenException;
import com.dhia.pfemanager.pfemanager.user.exceptions.EnterpriseBlockedException;
import com.dhia.pfemanager.pfemanager.user.exceptions.EnterpriseNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authService;

    @PostMapping("/register/super_admin")
    public ResponseEntity<AuthenticationResponse> adminRegister(
            @RequestBody AdminRegisterRequest registerRequest
    ){
        return ResponseEntity.ok(authService.adminRegister(registerRequest));
    };
    @PostMapping("/register/enterprise")
    public ResponseEntity<AuthenticationResponse> enterpriseRegister(
            @RequestBody EnterpriseRegisterRequest registerRequest
    ) throws EmailTakenException {
        return ResponseEntity.ok(authService.enterpriseRegister(registerRequest));
    };

    @PostMapping("/register/intern")
    public ResponseEntity<AuthenticationResponse> interRegister(
            @RequestBody InternRegisterRequest registerRequest
    ) throws EmailTakenException, EnterpriseNotFoundException, EnterpriseBlockedException {
        return ResponseEntity.ok(authService.internRegister(registerRequest));
    };

    @PostMapping("/register/supervisor")
    public ResponseEntity<AuthenticationResponse> supervisorRegister(
            @RequestBody SupervisorRegisterRequest registerRequest
    ) throws EmailTakenException, EnterpriseBlockedException, EnterpriseNotFoundException {
        return ResponseEntity.ok(authService.supervisorRegister(registerRequest));
    };

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> Authenticate(
            @RequestBody AuthenticationRequest authenticationRequest
    ){
        return ResponseEntity.ok(authService.authenticate(authenticationRequest));
    };

    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        authService.refreshToken(request, response);
    };

}
