package com.dhia.pfemanager.pfemanager.user.enterprise;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/enterprises")
public class EnterpriseController {

    private final EnterpriseService enterpriseService;


    @GetMapping("/all")
    public ResponseEntity<List<EnterpriseDTO>> getAllEnterprises(){
        List<EnterpriseDTO> enterprises = enterpriseService.getAllEnterprises();
        return ResponseEntity.ok(enterprises);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<EnterpriseDTO>> getEnterpriseById(@PathVariable("id") Integer id){
        Optional<EnterpriseDTO> enterprise = enterpriseService.getEnterpriseById(id);
        return ResponseEntity.ok(enterprise);
    }

    @PutMapping("/block/{enterpriseId}")
    public void blockEnterprise
            (@PathVariable("enterpriseId") Integer enterpriseId )
            throws IllegalAccessException {
       enterpriseService.blockEnterprise(enterpriseId);
    }

    @PutMapping("/enable/{enterpriseId}")
    public void enableEnterprise
            (@PathVariable("enterpriseId")Integer enterpriseId)
            throws IllegalAccessException {
        enterpriseService.enableEnterprise(enterpriseId);
    }



}
