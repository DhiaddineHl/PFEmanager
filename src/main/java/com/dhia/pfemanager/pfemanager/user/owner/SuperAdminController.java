package com.dhia.pfemanager.pfemanager.user.owner;


import com.dhia.pfemanager.pfemanager.user.enterprise.Enterprise;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/admin-dashboard")
public class SuperAdminController {

    private final SuperAdminService superAdminService;

    @GetMapping("/enterprises")
    public ResponseEntity<List<Enterprise>> getAllEnterprises () {
        List<Enterprise> enterprises = superAdminService.getAllEnterprises();
        return new ResponseEntity<>(enterprises, HttpStatus.OK);
    }

}
