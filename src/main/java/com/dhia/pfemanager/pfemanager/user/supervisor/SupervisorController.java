package com.dhia.pfemanager.pfemanager.user.supervisor;


import com.dhia.pfemanager.pfemanager.user.intern.InternDTO;
import com.dhia.pfemanager.pfemanager.user.intern.InternService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/supervisor")
public class SupervisorController {

    private final SupervisorService supervisorService;

    @GetMapping("/all")
    public ResponseEntity<List<SupervisorDTO>> getAllSupervisors(){
        List<SupervisorDTO> supervisors = supervisorService.getAllSupervisors();
        return ResponseEntity.ok(supervisors);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<SupervisorDTO>> getSupervisorById(@PathVariable("id") Integer id){
        Optional<SupervisorDTO> supervisor = supervisorService.getSupervisorById(id);
        return ResponseEntity.ok(supervisor);
    }

    @GetMapping("/byEnterprise/{enterpriseId}")
    public ResponseEntity<List<SupervisorDTO>> getSupervisorsByEnterprise(@PathVariable("enterpriseId") Integer enterpriseId){
        List<SupervisorDTO> supervisorsByEnterprise = supervisorService.getSupervisorsByEnterpriseId(enterpriseId);
        return ResponseEntity.ok(supervisorsByEnterprise);
    }

}
