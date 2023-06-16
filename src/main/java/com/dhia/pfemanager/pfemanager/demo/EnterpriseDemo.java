package com.dhia.pfemanager.pfemanager.demo;


import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo/enterprise")
public class EnterpriseDemo {

    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("enterprise interface");
    }

}
