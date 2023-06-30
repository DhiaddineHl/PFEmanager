package com.dhia.pfemanager.pfemanager.user.enterprise;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/enterprises")
@CrossOrigin(origins = "http://localhost:4200/enterpriseList")
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

    @PutMapping("/block")
    public void blockEnterprise(@RequestBody BlockAndEnableRequest request) throws IllegalAccessException {
       enterpriseService.blockEnterprise(request.getEnterpriseEmail());
    }

    @PutMapping("/enable")
    public void enableEnterprise(@RequestBody BlockAndEnableRequest request) throws IllegalAccessException {
        enterpriseService.enableEnterprise(request.getEnterpriseEmail());
    }



}
